## 🔄 Sequence Diagram (Predictive Autoscaling Flow)

```mermaid
sequenceDiagram
    participant User
    participant App as Spring Boot App
    participant Actuator
    participant Prometheus
    participant ML as ML Service (LSTM)
    participant K8s as Kubernetes API
    participant Pods as Application Pods

    User->>App: Send Requests
    App->>Actuator: Expose Metrics (/actuator/prometheus)

    Prometheus->>Actuator: Scrape Metrics (interval)
    Actuator-->>Prometheus: Return Metrics Data

    ML->>Prometheus: Query Metrics API
    Prometheus-->>ML: Return Historical Data

    ML->>ML: Train LSTM Model
    ML->>ML: Predict Future Load

    ML->>K8s: Send Scaling Decision (replicas)
    K8s->>Pods: Scale Up / Down

    Pods-->>App: Handle Increased Traffic
