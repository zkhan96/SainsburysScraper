#!/bin/bash
javac -d out/production/SainsburysScraper src/*.java
jar cfvm SainsburysScraper.jar src/META-INF/MANIFEST.MF -C out/production/SainsburysScraper/ SainsburysScraper.class