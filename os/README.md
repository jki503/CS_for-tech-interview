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
  - [**ch3. Processes**](#ch3-processes)
    - [**프로세스 concept**](#프로세스-concept)
    - [**프로세스 life cycle**](#프로세스-life-cycle)
    - [**PCB**](#pcb)
    - [**Context Switch**](#context-switch)
    - [**zombie 프로세스와 orphan 프로세스의 차이**](#zombie-프로세스와-orphan-프로세스의-차이)

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

### **ch3. Processes**

</br>

> 하나의 실행되는 프로그램으로 os에서 작업의 단위

</br>

- 프로세스가 필요한 자원들
  - CPU Time
  - memory
  - files
  - I/O devices

</br>

#### **프로세스 concept**

</br>

|               process - memory                |
| :-------------------------------------------: |
| ![process concept](./res/process_concept.png) |

</br>

| segment |                  description                  |
| :-----: | :-------------------------------------------: |
|  text   |             실행되는 명령어 코드              |
|  data   |            전역 변수, 배열, 구조체            |
|  heap   |  run time에서 동적으로 할당되는 메모리 공간   |
|  stack  | 함수 호출 시 생성 되고, 종료시 반환 되는 영역 |

> `data 영역`은 initialized와 uninitialized가 있다.  
> runtime 이후에 결정되는 uninitialized가 메모리 관점에서 효율적
>
> `stack`만 메모리의 상위 영역부터 할당되는 segment
>
> `heap`이 커지면 `stack` 영역이 작아지고 역도 성립

</br>

#### **프로세스 life cycle**

</br>

|               process life cycle                |
| :---------------------------------------------: |
| ![processs_life_cycle](./res/process_cycle.png) |

</br>

> - 프로세스가 생성되고 `ready queue`에 들어감
> - scheduler dispatch로 `running` 상태
> - 실행중인 프로세스는
>   - IO나 event 발생 시 `wating queue`로
>   - interrupt 발생 시 `ready queue`로 이동
> - running 상태에서 exit이나 프로세스를 반환하면 종료

#### **PCB**

</br>

|             data              |                      description                      |
| :---------------------------: | :---------------------------------------------------: |
|              PID              |                    프로세스 식별자                    |
|         Process state         |               프로세스 cycle 중에 상태                |
|              PC               |       현재 프로세스가 실행할 다음 명령어의 주소       |
|         CPU registers         |                        DR, IR                         |
| Memory-mangaement information |                                                       |
|    Acoounting information     |       페이지 테이블, 스케줄링 큐 포인터 부모 등       |
|          I/O status           | 프로세스에 할당된 입출력 장치 목록, 열린 파일 목록 등 |

</br>

#### **Context Switch**

</br>

> 현재 프로세스에서 인터럽트가 발생할 경우  
> 시스템이 현재 프로세스의 컨텍스트를 저장하고,
> 실행되어야할 프로세스의 컨텍스트를 재개하는 것

</br>

#### **zombie 프로세스와 orphan 프로세스의 차이**

> - zombie 프로세스는 부모 프로세스가 wait() call을 하지 않았을때 자식 프로세스가 종료 되는것
>
>   - 2022.03.04 기준 -> 다음날 내용 추가
>
> - orphan 프로세스는 부모 프로세스가 wait() call을 하지 않아 자식 프로세스가 먼저 종료 되는 경우
>   - 이때 init 프로세스가 호출되어 자식 프로세스가 새로운 부모 프로세스가 됨

</br>
</br>
</br>
