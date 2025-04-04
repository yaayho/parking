#!/bin/sh

# Validar que H2_PASSWORD esté definida
if [ -z "$H2_PASSWORD" ]; then
    echo "ERROR: H2_PASSWORD empty"
    exit 1
fi

# Convertir variable H2_DBS en array
DB_NAMES=$(echo "${H2_DBS}" | tr ',' ' ')

# Crear cada base de datos
for H2_DB in ${DB_NAMES}; do
  if [ ! -f "${H2_DATA}/${H2_DB}.mv.db" ]; then
    echo "Creando base de datos ${H2_DB} en ${H2_DATA}"
    java -cp h2.jar org.h2.tools.Shell -url "jdbc:h2:${H2_DATA}/${H2_DB}" \
      -user sa -password "${H2_PASSWORD}" -sql "CREATE TABLE IF NOT EXISTS INITIALIZED (ID INT PRIMARY KEY);"
  fi
done

# Iniciar servidor H2
exec java -cp h2.jar org.h2.tools.Server \
  -tcp -tcpAllowOthers -tcpPort "${H2_TCP_PORT}" \
  -web -webAllowOthers -webPort "${H2_WEB_PORT}" \
  -baseDir "${H2_DATA}"