package com.farhad.example.dddbank.infrastructure.persistence.rest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Stream;

import com.farhad.example.dddbank.domain.model.Client;

public class Converter {
	private static final DateTimeFormatter ISO_DATE_FORMATTER = DateTimeFormatter.ISO_DATE;

	String toString(final LocalDate localDate){
		return ISO_DATE_FORMATTER.format(localDate);
	}

	LocalDate toLocaldate(final String isoDateString){
		return LocalDate.parse(isoDateString, ISO_DATE_FORMATTER);
	}

	public ClientResource toClientResource(final Client entity) {
		final ClientResource result = new ClientResource(entity.getId(), entity.getUsername(), toString(entity.getBirthDate()));
		return result;
	}

	ClientResource[] clientsToResources(final List<Client> clients) {
		final Stream<ClientResource> result = clients.stream().map(this::toClientResource);
		return result.toArray(ClientResource[]::new);
		
	}

}
