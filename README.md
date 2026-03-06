<div align="center">
  
  <br>
  <img src="https://icongr.am/feather/server.svg?size=48&color=A1A1A6" />

  <br>
  
  <h1 style="color: #FFFFFF; font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Helvetica, Arial, sans-serif;">
    <b>TASK SCHEDULER</b>
  </h1>
  <p style="color: #A1A1A6;"><i>Backend-For-Frontend Gateway & Microservices Ecosystem</i></p>

  <a href="https://github.com/pedroforbeck">
    <!-- Apple System Font (San Francisco) & Titanium Silver Color -->
    <img src="https://readme-typing-svg.demolab.com?font=-apple-system,BlinkMacSystemFont,San+Francisco,Helvetica+Neue&weight=400&size=14&duration=4000&pause=1000&color=A1A1A6&center=true&vCenter=true&width=600&lines=Enterprise+Microservices+Architecture;Stateless+JWT+Authentication;Event-Driven+Task+Orchestration;API+Gateway+%26+BFF+Pattern" alt="Typing SVG" />
  </a>

  <br><br>

  <!-- Core Tech Stack (Space Gray Aesthetic) -->
  <img src="https://img.shields.io/badge/Java_17-1C1C1E?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java" />
  <img src="https://img.shields.io/badge/Spring_Boot-1C1C1E?style=for-the-badge&logo=spring-boot&logoColor=white" alt="Spring Boot" />
  <img src="https://img.shields.io/badge/PostgreSQL-1C1C1E?style=for-the-badge&logo=postgresql&logoColor=white" alt="PostgreSQL" />
  <img src="https://img.shields.io/badge/Docker-1C1C1E?style=for-the-badge&logo=docker&logoColor=white" alt="Docker" />
  <img src="https://img.shields.io/badge/JWT_Auth-1C1C1E?style=for-the-badge&logo=jsonwebtokens&logoColor=white" alt="JWT" />

  <br><br>

  <!-- Architecture Badges (Space Gray Aesthetic) -->
  <img src="https://img.shields.io/badge/Security-JWT%20%2B%20RBAC-1C1C1E?style=for-the-badge&logo=jsonwebtokens&logoColor=white" alt="Security" />
  <img src="https://img.shields.io/badge/Pattern-BFF%20Gateway-1C1C1E?style=for-the-badge&logo=diagramsdotnet&logoColor=white" alt="Pattern" />

</div>

<br><br>

> **Abstract**<br>
> This repository serves as the **Backend-For-Frontend (BFF)** and core **API Gateway** for a distributed Task Scheduling ecosystem. It abstracts the underlying microservices complexity, orchestrates network traffic, and enforces global security policies (JWT & RBAC) before any request reaches the internal domain services.

<br>

## <img src="https://icongr.am/feather/layers.svg?size=24&color=A1A1A6" align="absmiddle" /> Table of Contents

- [Ecosystem Architecture](#-ecosystem-architecture)
- [Core Capabilities](#-core-capabilities)
- [System Demonstration](#-system-demonstration)
- [Deployment & Orchestration](#-deployment--orchestration)
  - [1. Docker Deployment](#1-docker-deployment)
  - [2. Workspace Initialization](#2-workspace-initialization)
  - [3. Bootstrapping Services](#3-bootstrapping-services)
- [API Reference](#-api-reference)

---

## <img src="https://icongr.am/feather/cpu.svg?size=24&color=A1A1A6" align="absmiddle" /> Ecosystem Architecture

Instead of a monolithic approach, the domain is strictly decoupled into focused microservices. This ensures high availability, isolated horizontal scaling, and strict separation of concerns.

| Component | Port | Designation | Repository Link |
| :--- | :---: | :--- | :--- |
| **BFF / Gateway** | `8080` | Entry node. Handles authentication validation and request routing. | *(Current Repository)* |
| **User Service** | `8081` | Identity Provider (IdP). Manages credentials and JWT issuance. | [pedroforbeck/usuario](https://github.com/pedroforbeck/usuario) |
| **Task Service** | `8082` | Core Engine. Manages task state machines and cron execution. | [pedroforbeck/agendador-tarefas](https://github.com/pedroforbeck/agendador-tarefas) |
| **Notification** | `8083` | Event Listener. Dispatches asynchronous alerts based on task states. |[pedroforbeck/notificacao](https://github.com/pedroforbeck/notificacao) |

<br>

<details>
<summary><b style="color: #A1A1A6; cursor: pointer;">View System Topology (Glass/Wireframe Diagram)</b></summary>
<br>

```mermaid
graph TD;
    %% Glassmorphism / 
    classDef default fill:none,stroke:#A1A1A6,stroke-width:1px,color:#A1A1A6,rx:8,ry:8;
    classDef gateway fill:none,stroke:#FFFFFF,stroke-width:2px,color:#FFFFFF,rx:12,ry:12;
    classDef db fill:none,stroke:#007AFF,stroke-width:1px,color:#007AFF,rx:4,ry:4;

    %% Nodes
    Client([Client Application]):::default
    BFF{BFF Gateway API}:::gateway
    
    User[Identity Service]:::default
    Task[Task Orchestrator]:::default
    Notify[Notification Service]:::default
    
    DB[(PostgreSQL Cluster)]:::db

    %% Connections
    Client == "REST / JWT" ==> BFF
    BFF -- "Auth Validation" --> User
    BFF -- "Task Commands" --> Task
    Task -. "Async Event" .-> Notify
    
    User --> DB
    Task --> DB
```
</details>

---

## <img src="https://icongr.am/feather/command.svg?size=24&color=A1A1A6" align="absmiddle" /> Core Capabilities

| Feature | Description |
| :--- | :--- |
| <img src="https://icongr.am/feather/lock.svg?size=18&color=A1A1A6" align="absmiddle" /> **Stateless Auth** | Secure session management utilizing signed JSON Web Tokens (JWT). |
| <img src="https://icongr.am/feather/shield.svg?size=18&color=A1A1A6" align="absmiddle" /> **RBAC Security** | Granular endpoint protection ensuring strict data privacy and authorization. |
| <img src="https://icongr.am/feather/clock.svg?size=18&color=A1A1A6" align="absmiddle" /> **Automated Cron** | Resilient execution of scheduled tasks leveraging Spring's internal scheduling algorithms. |
| <img src="https://icongr.am/feather/layout.svg?size=18&color=A1A1A6" align="absmiddle" /> **BFF Pattern** | Aggregates and tailors data responses specifically for the client interface. |
| <img src="https://icongr.am/feather/radio.svg?size=18&color=A1A1A6" align="absmiddle" /> **Event-Driven** | Decoupled asynchronous notifications triggered dynamically by task lifecycle events. |

---

## <img src="https://icongr.am/feather/play-circle.svg?size=24&color=A1A1A6" align="absmiddle" /> System Demonstration

<!-- Recording -->
<div align="center">
  <img src="https://raw.githubusercontent.com/pedroforbeck/bff-agendador-tarefas/main/assets/demo.gif" alt="API Demonstration GIF" width="800" style="border-radius: 12px; border: 1px solid #30363D; box-shadow: 0 10px 30px rgba(0,0,0,0.5);">
  <br><br>
  <p style="color: #A1A1A6;"><i>Interactive API documentation and workflow testing via Swagger UI.</i></p>
</div>

---

## <img src="https://icongr.am/feather/terminal.svg?size=24&color=A1A1A6" align="absmiddle" /> Deployment & Orchestration

### 1. Docker Deployment
For a streamlined, containerized approach, you can easily pull the pre-built application image directly from the Docker registry:

```bash
docker pull pedroforbeck/bff-agendador-tarefas:latest
```

> **Registry & Resources:**
> * <img src="https://icongr.am/feather/box.svg?size=14&color=A1A1A6" align="absmiddle" /> **Docker Hub:**[pedroforbeck/bff-agendador-tarefas](https://hub.docker.com/repository/docker/pedroforbeck/bff-agendador-tarefas/general)
> * <img src="https://icongr.am/feather/github.svg?size=14&color=A1A1A6" align="absmiddle" /> **Source Code:** [GitHub Repository](https://github.com/pedroforbeck/bff-agendador-tarefas)

<br>

### 2. Workspace Initialization
To run the ecosystem locally from source, all microservices must be instantiated in the correct sequence. Ensure you have **Java 17+**, **Maven 3.8+**, and **PostgreSQL** installed.

Create an isolated directory and clone the complete ecosystem repository suite:

```bash
mkdir task-scheduler-ecosystem && cd task-scheduler-ecosystem

# Clone underlying services
git clone https://github.com/pedroforbeck/usuario.git
git clone https://github.com/pedroforbeck/agendador-tarefas.git
git clone https://github.com/pedroforbeck/notificacao.git

# Clone the Gateway (BFF)
git clone https://github.com/pedroforbeck/bff-agendador-tarefas.git
```

### 3. Bootstrapping Services
Ensure your PostgreSQL instance is running and the required databases are created. Open separate terminal instances for each service and execute them in the following order:

**Terminal A: Identity Provider**
```bash
cd usuario
./mvnw spring-boot:run
```

**Terminal B: Task Engine**
```bash
cd agendador-tarefas
./mvnw spring-boot:run
```

**Terminal C: Notification Listener**
```bash
cd notificacao
./mvnw spring-boot:run
```

**Terminal D: BFF Gateway (Entrypoint)**
```bash
cd bff-agendador-tarefas
./mvnw spring-boot:run
```

> **Note on Environment Variables:** 
> The BFF Gateway (`application.properties`) requires the following configurations to route traffic successfully. Adjust them according to your local setup:
> ```properties
> server.port=8080
> jwt.secret=<YOUR_SECURE_256_BIT_KEY>
> service.usuario.url=http://localhost:8081
> service.agendador.url=http://localhost:8082
> ```

---

## <img src="https://icongr.am/feather/globe.svg?size=24&color=A1A1A6" align="absmiddle" /> API Reference

The ecosystem implements **OpenAPI 3.0** specifications. Once the BFF Gateway is active, the complete schema and interactive UI are exposed at:

* **Swagger UI:** [`http://localhost:8080/swagger-ui.html`](http://localhost:8080/swagger-ui.html)
* **Raw JSON Schema:**[`http://localhost:8080/v3/api-docs`](http://localhost:8080/v3/api-docs)

---

<div align="center">
  <br>
  <p style="color: #A1A1A6;">Architected and maintained by <b><a href="https://github.com/pedroforbeck" style="color: #A1A1A6; text-decoration: none;">Pedro Forbeck</a></b>.</p>
  <p>
    <a href="https://github.com/pedroforbeck">
      <img src="https://img.shields.io/badge/GitHub-1C1C1E?style=flat-square&logo=github&logoColor=white" alt="GitHub" />
    </a>
    <a href="https://www.linkedin.com/in/pedro-forbeck-180a98390/">
      <img src="https://img.shields.io/badge/LinkedIn-1C1C1E?style=flat-square&logo=linkedin&logoColor=white" alt="LinkedIn" />
    </a>
  </p>
</div>
