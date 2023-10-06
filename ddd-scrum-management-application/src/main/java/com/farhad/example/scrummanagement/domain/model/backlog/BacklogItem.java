package com.farhad.example.scrummanagement.domain.model.backlog;

import java.util.List;

import com.farhad.example.scrummanagement.domain.model.StoryPoints;
import com.farhad.example.scrummanagement.domain.model.backlog.task.Task;
import com.farhad.example.scrummanagement.domain.model.backlog.task.TaskId;
import com.farhad.example.scrummanagement.domain.model.base.ConcurrencySafeEntity;
import com.farhad.example.scrummanagement.domain.model.base.event.DomainEventPublisher;
import com.farhad.example.scrummanagement.domain.model.product.ProductId;
import com.farhad.example.scrummanagement.domain.model.release.ReleaseId;
import com.farhad.example.scrummanagement.domain.model.sprint.Sprint;
import com.farhad.example.scrummanagement.domain.model.sprint.SprintId;
import com.farhad.example.scrummanagement.domain.model.team.Team;
import com.farhad.example.scrummanagement.domain.model.team.TeamId;
import com.farhad.example.scrummanagement.domain.model.team.TeamMemberId;
import com.farhad.example.scrummanagement.domain.model.tenant.TenantId;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class BacklogItem extends ConcurrencySafeEntity{
    
    private BacklogItemId backlogItemId;
    private TenantId tenantId;
    private TeamId teamId;
    private ProductId productId;
    private ReleaseId releaseId;
    private SprintId sprintId;
    private List<Task> tasks;

    private String status;
    private String story;
    private StoryPoints storyPoints;

    public void assignTeamMemberToTask(TeamMemberId teamMemberId, 
                                        Team ofTeam, 
                                        TaskId taskId) {
    }

    public void commitTo(Sprint aSprint) {

        // ...
        DomainEventPublisher
            .instance()
            .publish(
                new BacklogItemCommited(
                    this.tenantId,
                    this.backlogItemId,
                    this.sprintId));

    }
}
