# 

## 클라우드 네이티브 아키텍처(IaaS)
### 클라우드 아키텍처 설계
- 클라우드 아키텍처 구성, MSA 아키텍처 구성도


## 클라우드 네이티브 모델링 (Biz.)
### Data Modeling/서비스 분리/설계 역량
- 도메인분석 - 이벤트스토밍

![stoming](https://github.com/user-attachments/assets/6d32f633-074e-45fe-9096-5cd3a6551bf2)

## 클라우드 네이티브 개발 MSA (Dev.)
### MSA 개발 또는 개발관리 역량
- 분산트랜잭션 - Saga

![saga_0](https://github.com/user-attachments/assets/48a26fa4-b888-48ad-a71f-f0612e949fa9)
![saga_1](https://github.com/user-attachments/assets/d5c4ceef-34e8-4e71-8f3e-d1cd0e836b20)
![saga_2](https://github.com/user-attachments/assets/6bca75b7-77ab-426a-849c-fe45e6dbb7b9)
![saga_3](https://github.com/user-attachments/assets/6bc40d16-d973-42ec-9290-ce5c0c35e018)

- 보상처리 - Compensation
  
- 단일 진입점 - Gateway
  
![게이트웨이](https://github.com/user-attachments/assets/19c7f55f-f2fc-499e-8175-6e9d889736bb)

- 분산 데이터 프로젝션 CQRS

## 클라우드 네이티브 운영 (PaaS)
### 클라우드 배포 역량
- 클라우드 배포 - Container 운영

  
## Before Running Services
### Make sure there is a Kafka server running
```
cd kafka
docker-compose up
```
- Check the Kafka messages:
```
cd infra
docker-compose exec -it kafka /bin/bash
cd /bin
./kafka-console-consumer --bootstrap-server localhost:9092 --topic
```

## Run the backend micro-services
See the README.md files inside the each microservices directory:

- seatselection
- seat
- reservation
- customercenter


## Run API Gateway (Spring Gateway)
```
cd gateway
mvn spring-boot:run
```

## Test by API
- seatselection
```
 http :8088/seatSelections id="id" seatId="seatId" customerId="customerId" status="status" qty="qty" 
```
- seat
```
 http :8088/seats id="id" seatQty="seatQty" 
```
- reservation
```
 http :8088/reservations id="id" constomerId="constomerId" orderId="orderId" 
```
- customercenter
```
```


## Run the frontend
```
cd frontend
npm i
npm run serve
```

## Test by UI
Open a browser to localhost:8088

## Required Utilities

- httpie (alternative for curl / POSTMAN) and network utils
```
sudo apt-get update
sudo apt-get install net-tools
sudo apt install iputils-ping
pip install httpie
```

- kubernetes utilities (kubectl)
```
curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl"
sudo install -o root -g root -m 0755 kubectl /usr/local/bin/kubectl
```

- aws cli (aws)
```
curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip"
unzip awscliv2.zip
sudo ./aws/install
```

- eksctl 
```
curl --silent --location "https://github.com/weaveworks/eksctl/releases/latest/download/eksctl_$(uname -s)_amd64.tar.gz" | tar xz -C /tmp
sudo mv /tmp/eksctl /usr/local/bin
```

