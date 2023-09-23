package com.farhad.example.election_layer.infrastructure;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farhad.example.election_layer.application.ElectionService;
import com.farhad.example.election_layer.application.dto.CandidateDTO;
import com.farhad.example.election_layer.application.dto.ElectionDTO;
import com.farhad.example.election_layer.application.dto.VoterDTO;
import com.farhad.example.election_layer.domain.candidate.Candidate.CandidateId;
import com.farhad.example.election_layer.domain.election.Election.ElectionId;
import com.farhad.example.election_layer.domain.voter.Voter.VoterId;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class ElectionResource {
    
    private final ElectionService electionService;

    @GetMapping("/elections")
    public Iterable<ElectionDTO> getElection() {
        return electionService.getElections();
    }

    @PostMapping(path = "/elections", consumes = MediaType.APPLICATION_JSON_VALUE)
    ElectionDTO beginElection(@RequestBody Map<String, String> request) {
        String name = request.get("name");
        return electionService.beginElection(name);
    }

    @PostMapping(path = "/elections/{electionId}/candidates", consumes = MediaType.APPLICATION_JSON_VALUE)
    CandidateDTO registerCandidate(@PathVariable("electionId") UUID electionId,
                                @RequestBody Map<String, String> request) {
        String name = request.get("name");
        return electionService.registerCandidate(new ElectionId(electionId), name);
    }

    @GetMapping("/candidates")
    Iterable<CandidateDTO> getCandidates() {
        return electionService.getCandidates();
    }

    @PostMapping(path = "/elections/{electionId}/voters", consumes = MediaType.APPLICATION_JSON_VALUE)
    VoterDTO registerVoter(@PathVariable("electionId") UUID electionId,
                        @RequestBody Map<String, String> request) {
        String name = request.get("name");
        return electionService.registerVoter(new ElectionId(electionId), name);
    }

    @GetMapping("/voters")
    Iterable<VoterDTO> getVoters() {
        return electionService.getVoters();
    }

    @PutMapping("/elections/{electionId}/candidates/{candidateId}/voters/{voterId}")
    void vote(@PathVariable("electionId") UUID electionId,
              @PathVariable("candidateId") UUID candidateId,
              @PathVariable("voterId") UUID voterId) {
        electionService.vote(new ElectionId(electionId), new CandidateId(candidateId), new VoterId(voterId));
    }

    @GetMapping("/elections/{electionId}")
    List<String> getStatistics(@PathVariable("electionId") UUID electionId) {
        return electionService.getStatistics(new ElectionId(electionId));
    }

    @RequestMapping("/**")
    Map<String, String> fallbackApiInfo(HttpServletRequest request) {
        URI uri = URI.create(request.getRequestURL().toString());
        String baseUrl = String.format("%s://%s", uri.getScheme(), uri.getAuthority());
        Function<String, String> url = path -> String.format("%s%s", baseUrl, path);
        Map<String, String> response = new HashMap<>();

        response.put("     show elections GET", url.apply("/elections"));
        response.put(" open new election POST", url.apply("/elections"));
        response.put("    show candidates GET", url.apply("/candidates"));
        response.put("register candidate POST", url.apply("/elections/{electionId}/candidates"));
        response.put("        show voters GET", url.apply("/voters"));
        response.put("    register voter POST", url.apply("/elections/{electionId}/voters"));
        response.put("               vote PUT", url.apply("/elections/{electionId}/candidates/{candidateId}/voters/{voterId}"));
        response.put("   election results GET", url.apply("/elections/{electionId}"));
        response.put("                  _self", uri.toString());
        return response;
    }

}
