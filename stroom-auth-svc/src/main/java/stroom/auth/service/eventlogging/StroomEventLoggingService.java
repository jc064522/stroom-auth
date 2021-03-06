/*
 * Copyright 2016 Crown Copyright
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

package stroom.auth.service.eventlogging;

import event.logging.AuthenticateAction;
import event.logging.AuthenticateLogonType;
import event.logging.AuthenticateOutcome;
import event.logging.Event;
import event.logging.ObjectOutcome;
import event.logging.Search;
import event.logging.User;
import event.logging.impl.DefaultEventSerializer;
import event.logging.impl.EventSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import stroom.auth.config.EventLoggingConfig;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.servlet.http.HttpServletRequest;

import static event.logging.AuthenticateOutcomeReason.ACCOUNT_LOCKED;
import static event.logging.AuthenticateOutcomeReason.INCORRECT_USERNAME_OR_PASSWORD;

@Singleton
/**
 * A service to allow other components to easily create Stroom logging events.
 */
public class StroomEventLoggingService {

    private static final Logger AUDIT_LOGGER = LoggerFactory.getLogger("event-logger");

    private final StroomEventFactory stroomEventFactory;

    private final EventSerializer eventSerializer = new DefaultEventSerializer();

    @Inject
    public StroomEventLoggingService(EventLoggingConfig config) {
        stroomEventFactory = new StroomEventFactory(config);
    }

    public void successfulLogin(final HttpServletRequest request, String usersEmail) {
        Event event = createAuthenticateEvent("Logon",
                request, usersEmail, AuthenticateAction.LOGON,
                "User logged in successfully.");
        stroomEventFactory.log(event);
    }

    public void failedLogin(final HttpServletRequest request, String usersEmail) {
        Event event = createAuthenticateEvent("Logon",
                request, usersEmail, AuthenticateAction.LOGON,
                "User attempted to log in but failed.");
        AuthenticateOutcome authenticateOutcome = new AuthenticateOutcome();
        authenticateOutcome.setReason(INCORRECT_USERNAME_OR_PASSWORD);
        event.getEventDetail().getAuthenticate().setOutcome(authenticateOutcome);
        stroomEventFactory.log(event);
    }

    public void failedLoginBecauseLocked(final HttpServletRequest request, String usersEmail) {
        Event event = createAuthenticateEvent("Logon",
                request, usersEmail, AuthenticateAction.LOGON,
                "User attempted to log in but failed because the account is locked.");
        AuthenticateOutcome authenticateOutcome = new AuthenticateOutcome();
        authenticateOutcome.setReason(ACCOUNT_LOCKED);
        event.getEventDetail().getAuthenticate().setOutcome(authenticateOutcome);
        stroomEventFactory.log(event);
    }

    public void logout(final HttpServletRequest request, String usersEmail) {
        Event event = createAuthenticateEvent("Logoff",
                request, usersEmail, AuthenticateAction.LOGOFF,
                "User logged off.");
        stroomEventFactory.log(event);
    }

    public void resetPassword(final HttpServletRequest request, String usersEmail) {
        Event event = createAuthenticateEvent("ResetPassword",
                request, usersEmail, AuthenticateAction.RESET_PASSWORD,
                "User reset their password");
        stroomEventFactory.log(event);
    }

    public void changePassword(final HttpServletRequest request, String usersEmail) {
        Event event = createAuthenticateEvent("ChangePassword",
                request, usersEmail, AuthenticateAction.CHANGE_PASSWORD,
                "User changed their password.");
        stroomEventFactory.log(event);
    }


    public void search(
            String typeId,
            HttpServletRequest request,
            String usersEmail,
            Search search,
            String description){
        Event.EventDetail eventDetail = new Event.EventDetail();
        eventDetail.setSearch(search);
        eventDetail.setTypeId(typeId);
        eventDetail.setDescription(description);
        Event event = stroomEventFactory.createEvent(request, usersEmail);
        event.setEventDetail(eventDetail);

        stroomEventFactory.log(event);
    }

    public void create(
            String typeId,
            HttpServletRequest request,
            String usersEmail,
            ObjectOutcome objectOutcome,
            String description){
        Event.EventDetail eventDetail = new Event.EventDetail();
        eventDetail.setCreate(objectOutcome);
        eventDetail.setDescription(description);
        eventDetail.setTypeId(typeId);
        Event event = stroomEventFactory.createEvent(request, usersEmail);
        event.setEventDetail(eventDetail);

        stroomEventFactory.log(event);
    }

    public void view(
            String typeId,
            HttpServletRequest request,
            String usersEmail,
            ObjectOutcome objectOutcome,
            String description){
        Event.EventDetail eventDetail = new Event.EventDetail();
        eventDetail.setView(objectOutcome);
        eventDetail.setDescription(description);
        eventDetail.setTypeId(typeId);
        Event event = stroomEventFactory.createEvent(request, usersEmail);
        event.setEventDetail(eventDetail);

        stroomEventFactory.log(event);
    }

    public void update(
            String typeId,
            HttpServletRequest request,
            String usersEmail,
            Event.EventDetail.Update update,
            String description){
        Event.EventDetail eventDetail = new Event.EventDetail();
        eventDetail.setUpdate(update);
        eventDetail.setDescription(description);
        eventDetail.setTypeId(typeId);
        Event event = stroomEventFactory.createEvent(request, usersEmail);
        event.setEventDetail(eventDetail);

        stroomEventFactory.log(event);
    }

    public void delete(
            String typeId,
            HttpServletRequest request,
            String usersEmail,
            ObjectOutcome objectOutcome,
            String description){
        Event.EventDetail eventDetail = new Event.EventDetail();
        eventDetail.setDelete(objectOutcome);
        eventDetail.setDescription(description);
        eventDetail.setTypeId(typeId);
        Event event = stroomEventFactory.createEvent(request, usersEmail);
        event.setEventDetail(eventDetail);

        stroomEventFactory.log(event);
    }

    public Event createAuthenticateEvent(
            String typeId,
            HttpServletRequest request,
            String usersEmail,
            AuthenticateAction authenticateAction,
            String description){
        User user = new User();
        user.setId(usersEmail);
        Event.EventDetail.Authenticate authenticate = new Event.EventDetail.Authenticate();
        authenticate.setAction(authenticateAction);
        authenticate.setLogonType(AuthenticateLogonType.INTERACTIVE);
        authenticate.setUser(user);
        Event.EventDetail eventDetail = new Event.EventDetail();
        eventDetail.setAuthenticate(authenticate);
        eventDetail.setDescription(description);
        eventDetail.setTypeId(typeId);
        Event event = stroomEventFactory.createEvent(request, usersEmail);
        event.setEventDetail(eventDetail);

        return event;
    }

}