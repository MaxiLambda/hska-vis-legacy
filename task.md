# Verteilte Systeme

## Eingelogged
![image](https://hackmd.io/_uploads/BkWolB1JC.png)

## Klassen Diagram
![model.drawio](https://hackmd.io/_uploads/SJio2NJJR.png)

<div style="page-break-after: always;"></div>

## User Flow Diagram
![FlowDiagram.drawio](https://hackmd.io/_uploads/H1kEh41JC.png)

## Context Map / Bounded Context
![context-map.drawio (1)](https://hackmd.io/_uploads/S1e6fHJJA.png)

<div style="page-break-after: always;"></div>

## Erklärung für gewählten Bounded Context
Benutzerverwaltung:

Das System wird in Nutzerverwaltung und Produktmanagement geteilt.
Die Benutzerverwaltung ist vom Rest des Systems unabghänig, deswegen wird sie als eigener Bounded-Context abgebildet. Die zugehörigen Entitäten (Rolle und Nutzer) sind stark gekoppelt und bilden eine zusammenhängende Einheit.


Das Produktmangement, ist vom Rest des Systems unabhänging. Das Produktmangement setzt sich aus Product und Category zusammen, da diese beiden Enititäten fachlich eine Einheit bilden. 

