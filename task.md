# Verteilte Systeme

## Eingelogged
![Eingelogged](https://hackmd.io/_uploads/BkWolB1JC.png)

## Klassen Diagram
![Klassen Diagram](https://hackmd.io/_uploads/SJio2NJJR.png)

<div style="page-break-after: always;"></div>

## User Flow Diagram
![User Flow Diagram](https://hackmd.io/_uploads/H1kEh41JC.png)

## Context Map / Bounded Context
![Context Map / Bounded Context](https://hackmd.io/_uploads/S1e6fHJJA.png)

<div style="page-break-after: always;"></div>

## Erklärung für gewählten Bounded Context
Benutzerverwaltung:
Das System wird in Nutzerverwaltung und Produktmanagement geteilt. Die Benutzerverwaltung ist vom Rest des Systems unabhängig, deswegen wird sie als eigener Bounded-Context abgebildet. Die zugehörigen Entitäten (Rolle und Nutzer) sind stark gekoppelt und bilden eine zusammenhängende Einheit.
Das Produktmanagement ist ebenfalls vom Rest des Systems unabhängig. Es setzt sich aus Product und Category zusammen, da diese beiden Entitäten fachlich eine Einheit bilden.

## Aufgabe 2: Implementierung von Microservices

#### Git Commit: [Link](https://github.com/hka-iwi-vislab/hska-vis-legacy/commit/68d401a0cd75562cddfc900ad4c298716fd67f28)

### Implementierung mit Spring-Boot und Docker
- Verwendung von Spring-Boot für die Implementierung der Microservices.
- Verwendung von Docker für die Containerisierung der Microservices.

### Integration in Docker Compose Konfiguration
- Integration der Microservice-Container in die Docker Compose Konfiguration aus Aufgabe 1.
- Verwendung des MySQL Containers aus Aufgabe 1 als einziges DBMS mit mehreren DBs.

## Neues UML-Diagramm

![Neues UML-Diagramm](https://hackmd.io/_uploads/By32Beox0.png)

#### Beschreibung des Diagramms
Das neue UML-Diagramm zeigt eine logische Trennung der Klassen und ihre Beziehungen zueinander. Es wurden Verknüpfungen zwischen verschiedenen Implementierungen von Managern festgestellt: CategoryManagerImpl ist mit CategoryManager verbunden, ProductManagerImpl mit ProductManager und UserManagerImpls mit UserManager. Diese Verbindungen zeigen die Implementierung von Geschäftslogik und die entsprechenden Schnittstellen.

Des Weiteren wurden vier Data Access Objects (DAOs) identifiziert: ProductDAO, CategoryDAO, UserDAO und RoleDAO. Diese DAOs sind für den Zugriff auf die Datenbank zuständig und ermöglichen die Interaktion mit den entsprechenden Entitäten. Alle DAOs zeigen eine Abhängigkeit von "GenericHibernateDAO". Diese Abhängigkeit wurde eingeführt, um gemeinsame Funktionen zu bündeln und die Implementierung zu vereinheitlichen. "GenericHibernateDAO" selbst hat eine Abhängigkeit von "IGenericDAO", was auf eine weitere Abstraktionsebene hinweist und die Trennung von Geschäftslogik und Datenzugriff erleichtert.
