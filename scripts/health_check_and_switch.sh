#!/usr/bin/env bash
set -euo pipefail

if readlink -f /etc/nginx/conf.d/app_active.conf | grep -q "app_blue.conf"; then
  INACTIVE="green"
  NEW_LINK_TARGET="/etc/nginx/conf.d/app_green.conf"
  PORT=8082
else
  INACTIVE="blue"
  NEW_LINK_TARGET="/etc/nginx/conf.d/app_blue.conf"
  PORT=8081
fi

for i in {1..20}; do
  if curl -fsS "http://127.0.0.1:${PORT}/actuator/health" | grep -q "UP"; then
    OK=1; break
  fi
  sleep 3
done

if [[ "${OK:-0}" -ne 1 ]]; then
  echo "Health check failed on ${INACTIVE}"
  exit 1
fi

sudo ln -sfn "$NEW_LINK_TARGET" /etc/nginx/conf.d/app_active.conf
sudo nginx -t && sudo systemctl reload nginx
