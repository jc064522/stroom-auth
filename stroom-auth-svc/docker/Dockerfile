#**********************************************************************
# Copyright 2018 Crown Copyright
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#**********************************************************************

# ~~~ send logs download stage ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

# Intermediate build stage to grab all the send logs scripts
# later copy them all in one go to reduce the number of layers
# Have to use alpine rather than scratch so we can chmod
FROM alpine:3.8 as send-logs-scripts
WORKDIR /scripts

ADD https://raw.githubusercontent.com/gchq/stroom-clients/send-to-stroom-v1.0/bash/send_to_stroom.sh .
ADD https://raw.githubusercontent.com/gchq/stroom-clients/send-to-stroom-v1.0/bash/send_to_stroom_args.sh .
RUN chmod u+x ./*.sh
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~



# ~~~ Final build stage ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

# No java 10 alpine image currently available to use, so stuck with
# the not-so-slim debian-slim
FROM openjdk:10.0.2-jre-slim

WORKDIR /stroom-auth-service

# Volume for all application/access/event logs
VOLUME [ "/stroom-auth-service/logs" ]

# run entrypoint script inside tini for better unix process handling, 
# see https://github.com/krallin/tini/issues/8
ENTRYPOINT ["tini", "--", "./docker-entrypoint.sh"]

# Run the app
CMD ["sh", "-c", "echo \"JAVA_OPTS: [${JAVA_OPTS}]\"; java ${JAVA_OPTS} -jar stroom-auth-service-all.jar server config.yml"]

# cron used for sending logs to stroom.
# curl used for sending logs to stroom
# gosu/tini used for the entrypoint, to make it run as auth user
# procps used to provide 'ps' which is used by the send logs stuff
# Clear out apt-get cruft that wastes space
# add auth:auth user:group. Use id 1000 (for want of an id to use) as this is
# more likely to match the uid for a dev on the host. Not critical but may be
# beneficial in development.
# Ensure we have all the dirs we need
# Chown everything to the auth user
RUN apt-get update && \
    apt-get install -y \
        cron \
        curl \
        gosu \
        procps \
        tini && \
    rm -rf /var/lib/apt/lists/* && \
    addgroup --system --gid 1000 auth && \
    adduser --system --uid 1000 --shell /bin/false --ingroup auth auth && \
    mkdir -p /stroom-auth-service && \
    mkdir -p /stroom-auth-service/logs/access && \
    mkdir -p /stroom-auth-service/logs/events && \
    mkdir -p /stroom-auth-service/logs/app && \
    chown -R auth:auth /stroom-auth-service

# Copy in all the send logs scripts downloaded in the intermediate build stage
COPY --chown=auth:auth --from=send-logs-scripts /scripts /stroom-auth-service/

# Copy all the artifacts required to run stroom-auth-service
# In order of likelyhood to change, most staic first.
COPY --chown=auth:auth ./create_crontab.sh /stroom-auth-service/
COPY --chown=auth:auth ./docker-entrypoint.sh /stroom-auth-service/
COPY --chown=auth:auth ./build/config.yml /stroom-auth-service/
COPY --chown=auth:auth ./build/stroom-auth-service-all.jar /stroom-auth-service/

