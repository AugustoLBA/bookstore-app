package com.bookstore.jpa.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Set;
import java.util.UUID;

public record BookRecordDTO(@NotBlank(message = "O titulo do livro nao pode ser nulo!") String title,
                            @NotNull(message = "O ID da editora nao pode ser nulo!") UUID publisherId,
                            @NotNull(message = "O ID do Autor(s) nao pode ser nulo!") Set<UUID> authorsIds,
                            @NotBlank(message = "O comentario do review do livro nao pode ser nulo!") String reviewComment) {
}
