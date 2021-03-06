/*
 *
 *   Copyright 2017 Crown Copyright
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 */

package stroom.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.eclipse.jetty.http.HttpStatus;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import stroom.auth.config.Config;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

@Singleton
public class AuthorisationServiceClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthorisationServiceClient.class);

    public static final String UNAUTHORISED_USER_MESSAGE = "This user is not authorised to access this resource";

    private Config config;
    private Client authorisationService = ClientBuilder.newClient(new ClientConfig().register(ClientResponse.class));

    @Inject
    public AuthorisationServiceClient(Config config) {
        this.config = config;
    }

    public boolean isUserAuthorisedToManageUsers(String usersJws) {
        String authorisationUrl = config.getAuthorisationServiceConfig().getCanManageUsersUrl();
        Response response = authorisationService
                .target(authorisationUrl)
                .request()
                .header("Authorization", "Bearer " + usersJws)
                .post(getManageUserPermissionEntity());

        boolean isUserAuthorisedToManageUsers;

        switch (response.getStatus()) {
            case HttpStatus.UNAUTHORIZED_401:
                isUserAuthorisedToManageUsers = false;
                break;
            case HttpStatus.OK_200:
                isUserAuthorisedToManageUsers = true;
                break;
            case HttpStatus.NOT_FOUND_404:
                isUserAuthorisedToManageUsers = false;
                LOGGER.error("Received a 404 when trying to access the authorisation service! I am unable to check authorisation so all requests will be rejected until this is fixed. Is the service location correctly configured? Is the service running? The URL I tried was: {}", authorisationUrl);
                break;
            default:
                isUserAuthorisedToManageUsers = false;
                LOGGER.error("Tried to check authorisation for a user but got an unknown response! Response code was {}",
                        response.getStatus());
        }

        return isUserAuthorisedToManageUsers;
    }


    public Entity<Object> getManageUserPermissionEntity() {
        return Entity.json(new Object() {
            @JsonProperty
            private String permission =
                    config.getAuthorisationServiceConfig().getCanManageUsersPermission();
        });
    }
}
