# 

## 클라우드 네이티브 아키텍처(IaaS)
### 클라우드 아키텍처 설계
```
###### 클라우드 아키텍처 구성, MSA 아키텍처 구성도 ######
```




## 클라우드 네이티브 모델링 (Biz.)
### Data Modeling/서비스 분리/설계 역량
```
###### 도메인분석 - 이벤트스토밍 ######
```

- 1. 고객이 좌석을 선택하고 예약을 한다
- 2. 선택된 좌석에 대한 수량을 확인 후 처리를 진행한다
- 3. 처리 결과에 따라 예약완료 및 취소된다.

    ![stoming](https://github.com/user-attachments/assets/6d32f633-074e-45fe-9096-5cd3a6551bf2)





## 클라우드 네이티브 개발 MSA (Dev.)
### MSA 개발 또는 개발관리 역량
```
###### 분산트랜잭션 - Saga ######
```

- 분산트랜잭션을 위해 각 시스템을 기동시켜준다.
    ![saga_0](https://github.com/user-attachments/assets/48a26fa4-b888-48ad-a71f-f0612e949fa9)


- 좌석 5개를 생성한다                                                                    
    ![saga_1](https://github.com/user-attachments/assets/d5c4ceef-34e8-4e71-8f3e-d1cd0e836b20)
    

- 좌석 3개를 주문한다                                                        
    -![saga_2](https://github.com/user-attachments/assets/6bca75b7-77ab-426a-849c-fe45e6dbb7b9)

- 주문한 수량만큼 감소한 것을 확인한다                                                        
    -![saga_3](https://github.com/user-attachments/assets/6bc40d16-d973-42ec-9290-ce5c0c35e018)





```
###### 보상처리 - Compensation ######
```





```
###### 단일 진입점 - Gateway ######
```
- 각 서비스를 실행하고 gateway를 연결점으로 외부IP가 생성된것을 확인한다.                                              
    ![게이트웨이](https://github.com/user-attachments/assets/19c7f55f-f2fc-499e-8175-6e9d889736bb)






```
###### 분산 데이터 프로젝션 CQRS ######
```

## 클라우드 네이티브 운영 (PaaS)
### 클라우드 배포 역량
```
###### 클라우드 배포 - Container 운영 ######
```

- docker build를 통해 각 서비스들을 docker hub에 저장하여 관리한다.
    ![container](https://github.com/user-attachments/assets/a0b5877c-bf2d-4cf0-8eaa-4df19059fc3f)






### 컨테이너 인프라 설계 및 구성 역량
```
###### 컨테이너 자동확장 - HPA(Auto Scale out) ######
```

- Auto scale out 설정 후 seige 명령으로 부하를 주어서 Pod 가 늘어나도록 한다.
    ![오토스케일_1](https://github.com/user-attachments/assets/77f9d558-cff3-4385-b53c-e907efad9b41)

- kubectl get po -w 명령을 사용하여 pod 가 생성되는 것을 확인한다.
    ![오토스케일_2](https://github.com/user-attachments/assets/e84db82b-5008-4be0-a122-b3c72b5ca40f)

- kubectl get hpa 명령어로 CPU 값이 늘어난 것을 확인 한다.            
    ![오토스케일_3](https://github.com/user-attachments/assets/9b0babe6-f3b8-47ad-840f-04ce74ccccd3)






```
###### 컨테이너로부터 환경분리 - Secret ######
```

- 패스워드가 노출되면 안되므로 PASSWORD 에 대해서만 Secret 을 이용하여 분리해준다:
    ![secret_1](https://github.com/user-attachments/assets/f6f81076-5536-44cf-8c80-3e768fb8c232)

- echo $MYSQL_ROOT_PASSWORD를 통해 설정내용이 정상적으로 적용된지 확인한다.
    ![secret_2](https://github.com/user-attachments/assets/c03c5357-1646-4e67-97fc-977f85383327)

- 클러스터에 재배포 후 정상 기동 확인한다.
    ![secret_3](https://github.com/user-attachments/assets/845c8be3-937f-49a1-a48f-e3a963bdb38d)






```
###### 클라우드스토리지 활용 - PVC ######
```

- Azure 클라우드에 PVC(Persistence Volume Claim)를 생성하자.
    ![pvc_1](https://github.com/user-attachments/assets/096a6e7e-a244-4090-8307-247bc8eb37a1)

- 배포 후 주문 컨테이너에 접속하여 제대로 파일시스템이 마운트되었는지 확인한다.
    ![pvc_2](https://github.com/user-attachments/assets/0c4e102b-2c5c-42e9-a10b-abd909dd6718)

- 이후, 주문서비스를 2개로 Scale Out하고 확장된 주문 서비스에서도 test.txt가 확인되는지 검증한다.
    ![pvc_3](https://github.com/user-attachments/assets/95299078-56a1-4542-8b64-574cf96bbd61)

    ![pvc_4](https://github.com/user-attachments/assets/5939dd6c-e45a-435f-b630-95dfcbc1656a)






```
###### 셀프힐링 - Liveness ######
```

- Liveness Probe를 명시적으로 Fail 상태로 전환 후 UP -> DOWN 전환을 확인한다.
    ![liveness_1](https://github.com/user-attachments/assets/c5e253bb-4f99-4a5e-a7ab-1329bb7aec28)

- Probe Fail에 따른 쿠버네티스 동작을 확인한다.                
- 1.Warning Unhealthy - liveness probe failed : Http probe failed whith statuscode: 503 < 메시지를 통해 실패했음을 확인됨. 총 3번의 실패
- 2.Normal Killing - container order failed liveness probe, will be restarted < 메시지는 쿠버네티스가 해당 컨테이너를 종료 후 새로운 인스턴스를 시작할것이라는 의미.
- 3.Normal Started - Started container order < 자동으로 컨테이너가 성공적으로 시작됨.
    ![liveness_2](https://github.com/user-attachments/assets/ff00f327-e726-4eaf-97ef-510b00530aec)






```
###### 서비스 메쉬 응용 - Mesh ######
```

- Istio Service Mesh를 내 클러스터에 설치하고, 모니터링을 위한 대쉬보드를 추가 설정한다.
- 서비스 메시 모니터(kiali) 접속
    ![mesh_1](https://github.com/user-attachments/assets/e791a988-799f-4c15-a944-3a74c4801136)

- 각 서비스의 정상 실행 확인.
    ![mesh_2](https://github.com/user-attachments/assets/3021cb34-397d-4a9b-9d5f-a16ed6d93dc0)






```
###### 통합 모니터링 - Monitoring ######
```

- Grafana WebUI 설치 및 서비스 오픈 후 확인/접속
- Siege 터미널에서 주문서비스에 워크로드를 발생한다.
- Siege로 서비스 내에 오류상황을 만들고, 장애 호출을 보낸다.
    ![모니터링_1](https://github.com/user-attachments/assets/bba850fd-47e6-4dd0-800f-5c607714ceba)

    ![모니터링_2](https://github.com/user-attachments/assets/805d2ef4-4547-4b63-85a7-e77e3f28ff83)

    ![모니터링_3](https://github.com/user-attachments/assets/5d04ddd1-e1c4-43b1-ae5a-e43aee542709)

- 모니터링 결과 및 정상동작 확인.
    ![모니터링_4](https://github.com/user-attachments/assets/027e3b5e-6f46-4bfc-8e34-e95848a97855)


