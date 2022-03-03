---
title: OS
Category: OS, 운영체제
Author: Jung
---

- [Reference-inflearn](https://www.inflearn.com/course/%EC%9A%B4%EC%98%81%EC%B2%B4%EC%A0%9C-%EA%B3%B5%EB%A3%A1%EC%B1%85-%EC%A0%84%EA%B3%B5%EA%B0%95%EC%9D%98/lecture/63027?tab=note&volume=1.00&speed=2)

- Operating System, 저자 : Abraham Silberschatz , Peter Baer Galvin , Greg Gagne

</br>

## **My Goal**

---

</br>

- OS 공부
- 시간 절약 위해 강의로 하루에 수업 하나씩 듣고 필요한 부분 꼭 정리하기
- 배운 OS 지식들 명확하게 답변할 수 있도록 하기.

</br>
</br>
</br>

## **Table of Contents**

---

- [**My Goal**](#my-goal)
- [**Table of Contents**](#table-of-contents)
  - [**ch1-2. Introduction & O/S structures**](#ch1-2-introduction--os-structures)

</br>

### **ch1-2. Introduction & O/S structures**

</br>

- OS

> - 컴퓨터 시스템을 운영하는 소프트웨어
> - 컴퓨터에서 항상 실행되는 프로그램
> - `시스템 서비스를 애플리케이션에 지원하는 소프트 웨어`
> - `프로세스`, 자원, 유저 인터페이스 관리

</br>

- Program

> - `컴퓨터가 수행할 명령어들의 집합`

</br>

- 인터럽트

</br>

> 시스템 버스를 통해 처리가 필요한 경우 cpu로 신호를 전달하여 하드웨어가 처리할 수 있도록 하는것

</br>

- 멀티 프로그래밍

</br>

> CPU 사용률을 증가 시킬 수 있도록 메모리에 동시에 여러 프로세스를 로드하는 것

</br>

- 멀티 프로세싱

</br>

> 다수의 작업을 운영체제의 스케줄링에 의해 동시에 수행되도록 하는 것

</br>

- Operating System operations

</br>

> - usermode와 kernel mode로 나뉨
> - 유저에서 프로세스가 실행 되고, 시스템 콜을 호출
> - 커널은 시스템콜을 실행하고 유저에게 시스템 콜 정보를 반환
> - 프로그램을 악의적인 액션에 대해 보호하기 위해 나눈 구조

</br>
</br>
</br>
