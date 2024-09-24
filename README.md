# 

## 클라우드 네이티브 아키텍처(IaaS)
### 클라우드 아키텍처 설계
- 클라우드 아키텍처 구성, MSA 아키텍처 구성도


## 클라우드 네이티브 모델링 (Biz.)
### Data Modeling/서비스 분리/설계 역량
- 도메인분석 - 이벤트스토밍

```
1. 고객이 좌석을 선택하고 예약을 한다
2. 선택된 좌석에 대한 수량을 확인 후 처리를 진행한다
3. 처리 결과에 따라 예약완료 및 취소된다.
```
    ![stoming](https://github.com/user-attachments/assets/6d32f633-074e-45fe-9096-5cd3a6551bf2)

## 클라우드 네이티브 개발 MSA (Dev.)
### MSA 개발 또는 개발관리 역량
- 분산트랜잭션 - Saga

```
분산트랜잭션을 위해 각 시스템을 기동시켜준다.
```
    ![saga_0](https://github.com/user-attachments/assets/48a26fa4-b888-48ad-a71f-f0612e949fa9)
    
```
좌석 5개를 생성한다
```
    ![saga_1](https://github.com/user-attachments/assets/d5c4ceef-34e8-4e71-8f3e-d1cd0e836b20)
    
```
분산트랜잭션을 위해 각 시스템을 기동시켜준다.
```
    ![saga_2](https://github.com/user-attachments/assets/6bca75b7-77ab-426a-849c-fe45e6dbb7b9)

    ![saga_3](https://github.com/user-attachments/assets/6bc40d16-d973-42ec-9290-ce5c0c35e018)

- 보상처리 - Compensation
  
- 단일 진입점 - Gateway
  
    ![게이트웨이](https://github.com/user-attachments/assets/19c7f55f-f2fc-499e-8175-6e9d889736bb)

- 분산 데이터 프로젝션 CQRS

## 클라우드 네이티브 운영 (PaaS)
### 클라우드 배포 역량
- 클라우드 배포 - Container 운영

    ![container](https://github.com/user-attachments/assets/a0b5877c-bf2d-4cf0-8eaa-4df19059fc3f)

### 컨테이너 인프라 설계 및 구성 역량
- 컨테이너 자동확장 - HPA(AutoScaling)

    ![오토스케일_1](https://github.com/user-attachments/assets/77f9d558-cff3-4385-b53c-e907efad9b41)

    ![오토스케일_2](https://github.com/user-attachments/assets/e84db82b-5008-4be0-a122-b3c72b5ca40f)

    ![오토스케일_3](https://github.com/user-attachments/assets/9b0babe6-f3b8-47ad-840f-04ce74ccccd3)

- 컨테이너로부터 환경분리 - Secret

    ![secret_1](https://github.com/user-attachments/assets/f6f81076-5536-44cf-8c80-3e768fb8c232)

    ![secret_2](https://github.com/user-attachments/assets/c03c5357-1646-4e67-97fc-977f85383327)

    ![secret_3](https://github.com/user-attachments/assets/845c8be3-937f-49a1-a48f-e3a963bdb38d)

- 클라우드스토리지 활용 - PVC

    ![pvc_1](https://github.com/user-attachments/assets/096a6e7e-a244-4090-8307-247bc8eb37a1)

    ![pvc_2](https://github.com/user-attachments/assets/0c4e102b-2c5c-42e9-a10b-abd909dd6718)

    ![pvc_3](https://github.com/user-attachments/assets/95299078-56a1-4542-8b64-574cf96bbd61)

    ![pvc_4](https://github.com/user-attachments/assets/5939dd6c-e45a-435f-b630-95dfcbc1656a)

- 셀프힐링 - Liveness

    ![liveness_1](https://github.com/user-attachments/assets/c5e253bb-4f99-4a5e-a7ab-1329bb7aec28)

    ![liveness_2](https://github.com/user-attachments/assets/ff00f327-e726-4eaf-97ef-510b00530aec)


- 서비스 메쉬 응용 - Mesh

    ![mesh_1](https://github.com/user-attachments/assets/e791a988-799f-4c15-a944-3a74c4801136)

    ![mesh_2](https://github.com/user-attachments/assets/3021cb34-397d-4a9b-9d5f-a16ed6d93dc0)

- 통합 모니터링 - Monitoring

    ![모니터링_1](https://github.com/user-attachments/assets/bba850fd-47e6-4dd0-800f-5c607714ceba)

    ![모니터링_2](https://github.com/user-attachments/assets/805d2ef4-4547-4b63-85a7-e77e3f28ff83)

    ![모니터링_3](https://github.com/user-attachments/assets/5d04ddd1-e1c4-43b1-ae5a-e43aee542709)

    ![모니터링_4](https://github.com/user-attachments/assets/027e3b5e-6f46-4bfc-8e34-e95848a97855)

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

#### Required Utilities

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

