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
  - [**OSI 7계층**](#osi-7계층)
  - [**DNS**](#dns)
  - [**TCP 3-way-handshake & 4-way-handshake**](#tcp-3-way-handshake--4-way-handshake)

</br>
</br>
</br>

### **OSI 7계층**

|               OSI 7계층               |
| :-----------------------------------: |
| ![osi 7 layer](./res/osi_7layer.jpeg) |

> OSI 7계층은 네트워크 통신이 일어나는 과정을 7단계로 나누어  
> 문제가 발생하면 특정 단계에서 파악하여 해결할 수 있는 장점
>
> 송신 : 7 -> 1, 수신 : 1 -> 7  
> 하위 계층은 상위 계층을 위해 기능하며, 상위 계층은 하위 계층에 관여하지 않는 특징

</br>

- 1. 물리 (비트)

> 데이터를 전기적 신호로 변환해서 주고 받는 기능 진행하는 공간  
> 데이터를 전송하는 역할만 할 뿐 에러에 대해서는 신경 X  
> 리피터, 허브, 케이블 등

</br>

- 2. 데이터 링크 (프레임)

> 물리 계층으로 송수신되는 정보를 관리하여 안전하게 전달하도록 도와주는 역할  
> MAC 주소를 통해 통신하며, 프레임에 MAC 주소 부여, 에러검출, 재전송, 흐름제어를 진행  
> 브릿지, 스위치 등

</br>

- 3. 네트워크 계층 (패킷)

> 데이터를 목적지까지 가장 안전하고 빠르게 전달(라우팅)  
> 라우터를 통해 IP주소를 지정하고, 해당 경로에 패킷을 전달  
> 라우팅, 흐름제어, 세그멘테이션, 오류제어, internetworking  
> 라우터, IP

</br>

- 4. 트랜스포트 계층 (세그먼트)

> 통신을 활성화하는 계층으로, 포트를 열어 응용 프로그램들이 전송 할 수 있게 함.  
> 양 종단간의 사용자들이 신뢰성 있는 데이터를 주고 받을 수 있게 해줌.  
> TCP, IP

</br>

- 5. 세션 계층

> 양 종단의 프로세스가 데이터 통신을 위한 논리적 연결을 담당  
> 동시 송수신, 반이중, 전이중 통신과 함께 체크 포인트 유무, 종료, 다시 시작 과정등 수행  
> TCP/IP 세현을 만들고 없애는 책임 담당  
> API, Socket

</br>

- 6. 프레젠테이션 계층

> 데이터 표현에 대한 독립성 제공과 암호화하는 역할
> 파일 인코딩, 명령어 포장, 압축, 암호화
> TEXT, GIF, JPG 등

</br>

- 7. 어플리케이션 계층

> 사용자의 UI 및 입출력 부분을 담당하는 계층
> HTTP, FTP, SMPT, IMAP, POP3 등과 같은 프로토콜

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
