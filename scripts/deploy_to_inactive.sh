#!/usr/bin/env bash
set -euo pipefail

ACTIVE_LINK="/etc/nginx/conf.d/app_active.conf"

if readlink -f "$ACTIVE_LINK" | grep -q "app_blue.conf"; then
  INACTIVE="green"
  PORT=8082
else
  INACTIVE="blue"
  PORT=8081
fi

JAR_PATH="/opt/deploy/staging/app.jar"

PID=$(lsof -t -i:"$PORT" || true)
if [ -n "$PID" ]; then
  echo "Stopping ${APP_NAME} (PID: $PID)..."
  kill "$PID"
  sleep 3
fi

nohup java -jar "$JAR_PATH" --server.port="$PORT" > /dev/null 2> /dev/null < /dev/null &
