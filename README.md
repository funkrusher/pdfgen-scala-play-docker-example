# Pdfgen, Scala and Play-Framework Example

Dieses Beispielprojekt demonstriert die Verwendung von pdfgen in einer Scala / Play-Framework Umgebung
und das Starten des Projekt für die Live-Umgebung innerhalb eines Docker-Containers,
der mit dem sbt-native-plugin mit Docker erzeugt wurde.

# Create it

```
sbt docker:clean
sbt docker:stage
sbt docker:publishLocal
```

# Start it

```
docker run --rm -p 9000:9000 pdfgen-scala-play-example
```
