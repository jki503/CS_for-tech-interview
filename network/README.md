---
title: Network
Category: 네크워크, network
Author: Jung
---

## **My Goal**

---

</br>

- Network 용어 정리 및 기본 개념
- 네트워크 내부 동작 원리 이해하기

</br>
</br>
</br>

## **Table of Contents**

---

- [**My Goal**](#my-goal)
- [**Table of Contents**](#table-of-contents)
  - [**DNS**](#dns)
  - [**TCP 3-way-handshake & 4-way-handshake**](#tcp-3-way-handshake--4-way-handshake)

</br>
</br>
</br>

### **DNS**

</br>

- 정의

> 사용자가 웹 브라우저에서 접근하는 도메인에 대하여 IP와 라우팅 정보를 제공 해주는 시스템

</br>

|           DNS Recurive Query            |
| :-------------------------------------: |
| ![dns_query image](./res/dns_query.png) |

</br>

|     name      |                        description                         |
| :-----------: | :--------------------------------------------------------: |
|     Root      |                        루트 도메인                         |
|      TLD      |       상위 레벨 도메인과 국가 상위 레벨 도메인 관리        |
| authoritative | 실제 개인이나 기관의 도메인과 IP 주소 관계가 저장되는 서버 |
| Local(Cache)  |  도메인 이름과 매칭되는 IP 주소가 미리 캐시 되어있는 서버  |

</br>

- Domain으로 IP 주소를 얻는 과정

</br>

> 1. 사용자가 domain으로 요청시 Local DNS로 dns query 보냄.
> 2. Local DNS에 domain과 ip 주소의 관계가 캐시 되어 있으면 응답
> 3. Local DNS에 없으면 Root DNS로 요청
> 4. Root DNS에서 TLD 정보를 Local DNS로 전달
> 5. LOCAL DNS는 TLD에 요청
> 6. authoritative는 domain에 대한 IP를 Local DNS에 전달

</br>

> Local(있으면 바로 응답) -> Root -> Local -> TLD -> Local -> authoritative -> sLocal

</br>

- 사용자가 domain을 요청할때

</br>

> 1. Domain을 요청 받은 후 DNS 쿼리를 통해 IP 주소 반환
> 2. IP주소는 HTTP로 요청 메시지 생성 후 TCP통해 해당 IP의 컴퓨터로 전송
> 3. 도착한 HTTP 요청 메시지는 HTTP 사용 후 URL 정보에 대한 데이터 검색
> 4. 검색된 웹 페이지는 다시 HTTP 응답 메시지를 생성후 TCP를 사용하여 원래 컴퓨터로 전송
> 5. HTTP 응답 메시지가 웹 페이지 데이터로 변환 된 후 사용자에게 출력.

</br>
</br>
</br>

### **TCP 3-way-handshake & 4-way-handshake**

</br>

|            TCP 3-way-handshake            |
| :---------------------------------------: |
| ![tcp 3way-handshake](./res/tcp-3way.png) |

> - Client는 Sever로 SYN을 보내 접속 요청
> - Server는 SYN(x)를 받고 Client에게 ACK(y+1)과 SYN(y)를 보냄
> - Client는 ACK(y+1)을 보내어 접속 완료 상태

</br>

|            TCP 4-way-handshake            |
| :---------------------------------------: |
| ![tcp 4way-handshake](./res/tcp-4way.png) |

> - client는 server로 연결 종료 FIN 플래그 전송
> - server는 FIN을 받고, 이에 대한 확인 ACK를 client로 전송 (이때 모든 데이터를 내보내기 위해 close wait 상태)
> - 이떄 데이터를 모두 내보내면 연결이 종료 된다는 FIN 플래그를 client에게 전송
> - client는 우선 TIME WAIT상태로 데이터를 모두 받기 위해 기다린 후 이에 대한 확인 ACK를 서버로 보냄
>   - server는 ACK 받은 후 close
>   - TIME_WAIT 이후 client close

</br>
</br>
</br>
