package com.klaukeenterprises.oauthprotectedsetup;

import java.security.Principal;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class ExampleController {

  @GetMapping("/example")
  @PostAuthorize("hasAuthority('SCOPE_openid')")
  public ResponseEntity<String> welcome(
      @AuthenticationPrincipal Principal principal
  ) {
    return ResponseEntity.ok(principal.toString());
  }
}
