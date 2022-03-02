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
> 2. Local DNS에 domain과 ip 주소의 관계가 캐싱 되어 있으면 응답
> 3. Local DNS에 없으면 Root DNS로 요청
> 4. Root DNS는 (.com, .net)를 확인 한 후 TLD DNS의 정보를 Local DNS로 전달
> 5. Local DNS는 authoritative DNS에 domain을 요청한 후 ip 주소를 전달 받는다.

</br>

> Local(있으면 바로 응답) -> Root -> Local -> TLD -> Local -> authoritative -> Local

</br>

- 사용자가 domain을 요청할때

</br>

> 1. Domain을 요청 받은 후 DNS 쿼리를 통해 IP 주소 반환
> 2. IP주소는 HTTP로 요청 메시지 생성 후 TCP통해 해당 IP의 컴퓨터로 전송
> 3. 도착한 HTTP 요청 메시지는 HTTP 사용 후 URL 정보에 대한 데이터 검색
> 4. 검색된 웹 페이지는 다시 HTTP 응답 메시지를 생성후 TCP를 사용하여 원래 컴퓨터로 전송
> 5. HTTP 응답 메시지가 웹 페이지 데이터로 변환 된 후 사용자에게 출력.
