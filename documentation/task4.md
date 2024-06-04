# Verteilte Systeme

## Aufgabe 1: Diagramme und Bounded Context

### Eingelogged
![image](https://hackmd.io/_uploads/BkWolB1JC.png)

### Klassen Diagramm
![model.drawio](https://hackmd.io/_uploads/SJio2NJJR.png)

<div style="page-break-after: always;"></div>

### User Flow Diagram
![FlowDiagram.drawio](https://hackmd.io/_uploads/H1kEh41JC.png)

### Context Map / Bounded Context
![context-map.drawio (1)](https://hackmd.io/_uploads/S1e6fHJJA.png)

<div style="page-break-after: always;"></div>

### Erklärung für gewählten Bounded Context
**Benutzerverwaltung:**

Das System wird in Benutzerverwaltung und Produktmanagement aufgeteilt. Die Benutzerverwaltung ist vom Rest des Systems unabhängig und wird daher als eigener Bounded Context abgebildet. Die zugehörigen Entitäten (Rolle und Nutzer) sind stark gekoppelt und bilden eine zusammenhängende Einheit.

**Produktmanagement:**

Das Produktmanagement ist ebenfalls vom Rest des Systems unabhängig. Es besteht aus den Entitäten Product und Category, die fachlich eine Einheit bilden.

## Aufgabe 2: Implementierung von Microservices

### Git Commit: [Link](https://github.com/hka-iwi-vislab/hska-vis-legacy/commit/68d401a0cd75562cddfc900ad4c298716fd67f28)

### Implementierung mit Spring-Boot und Docker
- **Verwendung von Spring-Boot:** Zur Implementierung der Microservices.
- **Verwendung von Docker:** Zur Containerisierung der Microservices.

### Anforderungen an die Microservices
- Jeder Microservice stellt, wenn nötig, eine REST-API bereit.
- Jeder Microservice besitzt eine eigene Datenbank.

### Integration in Docker Compose Konfiguration
- Integration der Microservice-Container in die Docker Compose Konfiguration aus Aufgabe 1.
- Verwendung des MySQL Containers aus Aufgabe 1 als einziges DBMS mit mehreren Datenbanken.

### Neue UML-Diagramme 

#### UML-Diagramm für Usermanagement
![usermanagement](https://hackmd.io/_uploads/rkzdW-jxA.png)

**Beschreibung des Diagramms:**

Das UML-Diagramm für das Usermanagement zeigt logisch getrennte Klassen und entsprechende Verknüpfungen zwischen den relevanten Entitäten und Klassen. Die Rolle ist nun nur noch mit dem UserBuilder verknüpft, während der UserDTO abgekapselt ist. Die Klassen RoleRepository und UserController sind miteinander verknüpft, wobei der UserController das UserRepository verwendet. Klassen wie Category wurden aus diesem Kontext entfernt, da sie zum Produktmanagement gehören und nichts mit Benutzern und Rollen zu tun haben.

#### UML-Diagramm für Produktmanagement
![grafik](https://hackmd.io/_uploads/HJlRhss4C.png)

**Beschreibung des Diagramms:**

Das UML-Diagramm für das Produktmanagement zeigt logisch getrennte Klassen und entsprechende Verknüpfungen zwischen den relevanten Entitäten und Klassen. Es gibt abgekapselte Klassen wie UserCategoryDTO, ProductManagementApplication, CreateProductDTO und CreateCategoryDTO. Die zusammenhängenden Teile des Codes sind logisch miteinander verbunden, wo dies sinnvoll ist. Beispielsweise hat das Product einen ProductBuilder und eine Category, die den mit der Kategorie verknüpften CategoryBuilder verwendet, während die Kategorie den mit dem Produkt verbundenen ProductBuilder verwendet. Insgesamt ist der Code deutlich besser getrennt.

## Aufgabe 3: Kubernetes Cluster mit Minikube

### Vorbereitung
**eShop-Backend V3 (k8s-istio):**
1. Wir haben die Istio Einführung [WP20] gesichtet.
2. Unser k8s-Cluster wurde um eine Istio Installation erweitert und Istio für unsere Microservices aktiviert.
3. Experiment: Beobachtung von Aufrufen unserer Microservices mit Prometheus und Grafana.
4. Experiment: Anzeige der Topologie des Service Mesh als Graph mit Kiali.

### Ergebnisse und Screenshots

1. **Bild der Container (alle laufen):**
![containers running](https://hackmd.io/_uploads/ryMZvKfN0.png)

2. **Bild eines gestoppten Containers:**
![stopped contianer](https://hackmd.io/_uploads/HyEkvKz4R.png)

3. **Graph in Kiali:**
![kiali graph](https://hackmd.io/_uploads/r1gRLFGE0.png)

4. **Grafana Graphs:**
![grafana screen](https://hackmd.io/_uploads/B1JhUYzNR.png)
4.1. **Grafana Dashboard**
![grafik](https://hackmd.io/_uploads/HyOgkSn40.png)
![grafik](https://hackmd.io/_uploads/B1Z-JHhN0.png)


5. **Prometheus Graph:**
   ![prometheus graph](https://hackmd.io/_uploads/S1_5IYM4R.png)
   


<div style="page-break-after: always;"></div>

## Aufgabe 4: Serverseitige Frontend-Integration und Gesamtlösung

### 1. Serverseitige Frontend-Integration
a. **Zusammenfassung:** 
Wir haben eine neue Version des eShop erstellt, bei der die zuvor erstellten Microservices eingebunden sind. Der Monolith wurde in kleinere, unabhängige Microservices aufgeteilt, um eine bessere Skalierbarkeit und Wartbarkeit zu erreichen.

b. **Deployment:** 
Der eShop läuft neben den bereits existierenden Komponenten in unserem Kubernetes Cluster. Die Web GUI des eShop ist von außerhalb des Clusters erreichbar, was durch die Konfiguration von Ingress-Ressourcen ermöglicht wurde. Ein Ingress-Controller wird verwendet, um den Zugriff auf die Weboberfläche zu steuern und zu verwalten.

c. **Integration:** 
Die lokalen Implementierungen der ausgelagerten Anwendungsfunktionen wurden durch Zugriffe auf die entsprechenden Microservices ersetzt. Dies beinhaltete die Anpassung der API-Endpunkte und die Sicherstellung, dass die Kommunikation zwischen den Services über die Kubernetes Service Discovery und das interne Netzwerk erfolgt.

### 2. Test der Gesamtlösung
a. **Zusammenfassung:** 
Die neue Version des eShop wurde durch funktionale und nicht funktionale Tests evaluiert. Funktionale Tests umfassten die Überprüfung der grundlegenden Use Cases wie Nutzerregistrierung, Anmeldung, Produkt- und Kategorieverwaltung. Nicht funktionale Tests konzentrierten sich auf die Performanz und Skalierbarkeit der Lösung.

b. **Demonstrator:** 
Die korrekte Funktionsweise des eShop wurde anhand seiner Use Cases demonstriert.

#### Screenshots der Use Cases:
- ![vs screenshot registrierung](https://hackmd.io/_uploads/H1H_toiNA.png)
  - Der Nutzer kann sich erfolgreich registrieren.
- ![vs screenshot login](https://hackmd.io/_uploads/Hy_PFsj4A.png)
  - Der Nutzer kann sich erfolgreich anmelden.
- ![vs screenshot add product](https://hackmd.io/_uploads/S1IIKooE0.png)
  - Produkte können erfolgreich hinzugefügt werden.
- ![vs screenshot edit categories mit eingabe](https://hackmd.io/_uploads/H1UmtjiNA.png)
  - Neue Kategorien können erstellt und bearbeitet werden.
- ![vs screenshot edit categories mit ieingabe teil 2 (hier ist die kategorie namens neu eingefügt)](https://hackmd.io/_uploads/HJ8fFsoE0.png)
  - Detaillierte Ansicht einer neu erstellten Kategorie. Hier ist die Kategorie namens "neu" eingefügt.
- ![vs screenshot kategorie d gelöscht](https://hackmd.io/_uploads/HyWRujjNR.png)
  - Kategorien können gelöscht werden. Hier wurde Kategorie "d" gelöscht.
- ![vs screenshot products deleted](https://hackmd.io/_uploads/HkHauoiV0.png)
  - Produkte können gelöscht werden.
- ![vs screenshot search ohne suchbegriff](https://hackmd.io/_uploads/ByNsOos4R.png)
  - Die Produktsuche ohne spezifischen Suchbegriff zeigt alle verfügbaren Produkte.
- ![vs screenshot search mit suchbegriff](https://hackmd.io/_uploads/rJ8quiiVC.png)
  - Die Produktsuche mit einem spezifischen Suchbegriff liefert entsprechende Ergebnisse.
- ![vs screenshot search mit minpreis](https://hackmd.io/_uploads/rJjtdis4A.png)
  - Die Produktsuche mit einem minimalen Preisfilter funktioniert korrekt.
- ![vs screenshot search with price max](https://hackmd.io/_uploads/ByXFOsjER.png)
  - Die Produktsuche mit einem maximalen Preisfilter funktioniert korrekt.
- ![vs screenshot search with min and max price](https://hackmd.io/_uploads/rkYudjiVA.png)
  - Die Produktsuche mit sowohl minimalem als auch maximalem Preisfilter liefert die erwarteten Ergebnisse.
- ![vs screenshot Search Products (loads categories to resolve the id, products to show products, users - to check permissions)](https://hackmd.io/_uploads/Sk05qss4A.png)
  - Die Produktsuche lädt Kategorien zur Auflösung der IDs, Produkte zur Anzeige der Produkte und Benutzer zur Überprüfung der Berechtigungen.
- ![grafik](https://hackmd.io/_uploads/HJXYA42E0.png)
    - Die Produktdetailansicht funktioniert wie angefordert.

### Performanz und Skalierbarkeit
Anhand von Logging und Monitoring der Microservices wurden deren durchschnittliche Antwortzeiten für verschiedene Arten von Aufrufen ermittelt. Die korrekte Funktion des Load Balancing wurde anhand der Verteilung von Aufrufen auf Microservice-Instanzen gezeigt. Diese Tests wurden mit Werkzeugen wie Prometheus und Grafana durchgeführt, um detaillierte Metriken und Visualisierungen zu erhalten.

#### Ergebnisse der Performanztests:
- ![vs screenshot average response times Add Product](https://hackmd.io/_uploads/HkaOvjs40.png)
  - Die durchschnittlichen Antwortzeiten für das Hinzufügen von Produkten wurden gemessen und analysiert.
- ![vs screenshot kiali average respone time Add  Categorie](https://hackmd.io/_uploads/S1x9DioV0.png)
  - Die durchschnittlichen Antwortzeiten für das Hinzufügen von Kategorien wurden gemessen und analysiert.
- ![vs screenshot create user^response times kiali](https://hackmd.io/_uploads/r1xoDisVC.png)
  - Die durchschnittlichen Antwortzeiten für die Nutzererstellung wurden gemessen und analysiert.
- ![vs screenshot Product, response times](https://hackmd.io/_uploads/H1qhPjj4C.png)
  - Die Antwortzeiten für Produktabfragen wurden gemessen und analysiert.
- ![grafik](https://hackmd.io/_uploads/rJUwNN2NA.png)
    - Zusätzlich haben wir durch eine Postman Collection die gesamte API kontinuierlich unter Last getestet.
- ![vs screenshot loadbalancing shown in prometheus](https://hackmd.io/_uploads/r1Hpvss4C.png)
  - Die Lastverteilung zwischen den Microservice-Instanzen wurde mithilfe von Prometheus visualisiert und überprüft.
- ![vs screenshot kiali graph welche nodes senden an welche nodes](https://hackmd.io/_uploads/rkr0woiNA.png)
  - Ein Kiali-Graph zeigt die Kommunikation zwischen den verschiedenen Microservices.
- ![vs screenshot kiali 3 verschiedene Pods für Categorie](https://hackmd.io/_uploads/rJ4kuso40.png)
  - Die Verteilung der Kategorien-Microservices auf verschiedene Pods wurde visualisiert.
- ![grafik](https://hackmd.io/_uploads/Sy1lwB2NA.png)
    - Hier werden zusätzlich noch die Antwortzeiten des User-services aufgezeigt. 
