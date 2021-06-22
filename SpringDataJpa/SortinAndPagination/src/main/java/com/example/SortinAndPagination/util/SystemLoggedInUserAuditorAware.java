package com.example.SortinAndPagination.util;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

@Component
public class SystemLoggedInUserAuditorAware implements AuditorAware<String> {

  @Override
  public Optional<String> getCurrentAuditor() {
      return Optional.of("AG42993");
  }
}