#!/bin/sh
set -e

# Re-set permission to the `auth` user if current user is root
# This avoids permission denied if the data volume is mounted by root
if [ "$(id -u)" = '0' ]; then
    chown -R auth:auth .

    # This is a bit of a cludge to get round "Text file in use" errors
    # See: https://github.com/moby/moby/issues/9547
    # sync ensures all disk writes are persisted
    sync

    # Build the crontab file to send logs to stroom
    echo "Creating the crontab file"
    ./create_crontab.sh

    # Start the cron daemon
    echo "Starting cron"
    cron &

    #runs all args as user auth, rather than as root
    echo "Switching to user 'auth'"
    exec gosu auth "$@"
fi

exec "$@"
