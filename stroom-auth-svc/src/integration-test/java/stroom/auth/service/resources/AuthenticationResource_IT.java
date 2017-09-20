/*
 * Copyright 2017 Crown Copyright
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package stroom.auth.service.resources;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.Test;
import stroom.auth.service.resources.support.Base_IT;

import static stroom.auth.service.resources.support.HttpAsserts.assertBadRequest;
import static stroom.auth.service.resources.support.HttpAsserts.assertUnauthorised;

public class AuthenticationResource_IT extends Base_IT {
  @Test
  public void good_login() throws UnirestException {
    // Most API tests need to login so the actual login method is in the base class.
    // We're adding it as a test here for completeness.
    authenticationManager.loginAsAdmin();
  }

  @Test
  public void incorrect_credentials_1() throws UnirestException {
    HttpResponse response = Unirest
        .post(authenticationManager.getLoginUrl())
        .header("Content-Type", "application/json")
        .body("{\"email\" : \"BAD\", \"password\" : \"admin\"}")
        .asString();
    assertUnauthorised(response);

  }

  @Test
  public void incorrect_credentials_2() throws UnirestException {
    HttpResponse response = Unirest
        .post(authenticationManager.getLoginUrl())
        .header("Content-Type", "application/json")
        .body("{\"email\" : \"admin\", \"password\" : \"BAD\"}")
        .asString();
    assertUnauthorised(response);
  }

  @Test
  public void incorrect_credentials_3() throws UnirestException {
    HttpResponse response = Unirest
        .post(authenticationManager.getLoginUrl())
        .header("Content-Type", "application/json")
        .body("{\"email\" : \"BAD\", \"password\" : \"BAD\"}")
        .asString();
    assertUnauthorised(response);
  }

  @Test
  public void missing_credentials_1() throws UnirestException {
    HttpResponse response = Unirest
        .post(authenticationManager.getLoginUrl())
        .header("Content-Type", "application/json")
        .body("{\"email\" : \"BAD\"}")
        .asString();
    assertBadRequest(response);
  }

  @Test
  public void missing_credentials_2() throws UnirestException {
    HttpResponse response = Unirest
        .post(authenticationManager.getLoginUrl())
        .header("Content-Type", "application/json")
        .body("\"password\" : \"admin\"}")
        .asString();
    assertBadRequest(response);
  }

  @Test
  public void missing_credentials_3() throws UnirestException {
    HttpResponse response = Unirest
        .post(authenticationManager.getLoginUrl())
        .header("Content-Type", "application/json")
        .body("")
        .asString();
    assertBadRequest(response);
  }
}
