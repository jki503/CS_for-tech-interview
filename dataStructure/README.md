---
title: DataStructure,
category: algorithm,
tags: 자료구조, 자바, API정리
Author: Jung
---

## **My Goal**

---

- 자료구조 공부 겸 JAVA API 정리

</br>
</br>
</br>

## **Table of Contents**

---

- [**My Goal**](#my-goal)
- [**Table of Contents**](#table-of-contents)
  - [**Stack**](#stack)
    - [**Stack 명령어**](#stack-명령어)
    - [**push(E),empty() vs add(E),isEmpty()**](#pusheempty-vs-addeisempty)
  - [**Priority Queue**](#priority-queue)
    - [**Priority Queue 명령어**](#priority-queue-명령어)
  - [**Queue**](#queue)
    - [**Queue 명령어**](#queue-명령어)
  - [**HashSet**](#hashset)
    - [**Set 명령어**](#set-명령어)

</br>
</br>
</br>

### **Stack**

---

</br>

#### **Stack 명령어**

</br>

|    명령어    |           내용           |
| :----------: | :----------------------: |
|   push(E)    |       Element 넣기       |
|    add(E)    |       Element 넣기       |
|    peek()    |     스택 데이터 반환     |
|    pop()     | 스택 데이터 반환 후 삭제 |
|    size()    |     스택 사이즈 반환     |
| seach(index) |    stack index의 원소    |
|   empty()    |     비어있는지 체크      |
|   isEmpty    |     비어있는지 체크      |

</br>

```java
void stackPractice(){
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.add(5);

        System.out.println(stack.search(5)); //1출력
        System.out.println(stack.size()); // 5출력
        System.out.println(stack.peek()); // 5 출력

        while(!stack.empty()){ // isEmpty()도 가능
            System.out.println(stack.pop()); // 5, 4, 3, 2, 1 출력
        }
        stack.pop(); // EmptyStackException...
    }
```

- stack.seach(5)는 5가 첫번째 인덱스임으로 1출력
- peek()은 삭제하지 않음.
- peek()과 pop은 비어있는지 체크 안할 경우 `EmptyStackException` 가능성.

</br>

#### **push(E),empty() vs add(E),isEmpty()**

</br>

> - push,empty는 stack 함수.
> - add, isEmpty는 vector 함수.
> - stack이 vector를 상속받는 구조.

</br>
</br>
</br>

### **Priority Queue**

#### **Priority Queue 명령어**

> - 완전 이진트리 heap의 구조로 데이터 삽입 삭제 모두 O(logN)
> - 기본적으로 Queue를 implemets 한 AbstarctQueue를 부모로 받고 있음
> - [Queue명령어 참고](#queue-명령어)

</br>

```java
 void PriorityQueuePractice(){

        // MinHeap
        PriorityQueue<Integer> pqLower = new PriorityQueue<>();

        // MaxHeap
        PriorityQueue<Integer> pqHigher = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=1;i<6;i++){
            pqLower.offer(i);
            pqHigher.offer(i);
        }

        System.out.println("Lower int" + pqLower.poll()); // 1 출력

        while(!pqLower.isEmpty()){
            System.out.println("Lower int" +pqLower.poll()); // 2 3 4 5 출력
        }

        while(!pqHigher.isEmpty()){
            System.out.println(pqHigher.poll()); // 5 4 3 2 1 출력
        }
    }

```

</br>
</br>
</br>

### **Queue**

#### **Queue 명령어**

|   명령어    |                          내용                           |
| :---------: | :-----------------------------------------------------: |
|   add(E)    |    Element 추가(용량 없으면 `IllegalStateException`)    |
|  offer(E)   |                      Element 추가                       |
|  element()  |       원소 반환, 없으면 `NoSuchElementException`        |
|   peek()    |              원소 반환, 없으면 `Null 반환`              |
|  remove()   | 원소 지우고, 원소 반환, 없으면 `NoSuchElementException` |
|   poll()    |       원소 지우고, 원소 반환, 없으면 `null` 반환        |
|   size()    |           queue size 반환 (Collection 명령어)           |
| contains(O) |            포함되어 있는지 체크 (Collcetion)            |
|  isEmpty()  |           비어있는지 체크(Collection 명령어)            |

</br>

```java
    void queuePractice(){
        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);
        queue.offer(2);
        queue.offer(3);
        System.out.println(queue.size()); // 2출력

        while(!queue.isEmpty()){
            System.out.println(queue.poll()); // 1 2 3 출력
        }
        System.out.println(queue.peek()); //null 출력
        System.out.println(queue.poll()); // null 출력

        System.out.println(queue.element()); //NoSuchElementException
        System.out.println(queue.remove()); //NoSuchElementException
    }

```

</br>

> - 명령어마다 용도가 다름(null일때 error를 터트리느냐 반환하느냐)
> - 상황에 맞게 사용.

</br>

### **HashSet**

> - HashTable 자료구조로 삽입 조회 삭제가 O(1)으로 수렴
> - TreeSet은 삽입과 조회 삭제 모두 O(log n)
> - HashSet은 기본적으로 내부에서 생성한 HashMap을 사용하여 중복을 피하는 구조
> - null 값 허용

</br>

#### **Set 명령어**

|   명령어    |            내용             |
| :---------: | :-------------------------: |
|   add(E)    |          원소 추가          |
|  remove(E)  |          원소 삭제          |
| contains(e) | 원소 포함 여부 boolean 반환 |
| iterator()  |        iterator 생성        |
|   clear()   |          원소 삭제          |
|   size()    |       hashSet 사이즈        |
|   isEmpty   |   비어있는지 boolena 반환   |

```java

    void setPractice(){
        Set<Integer> hSet = new HashSet<>();
        int[] arr = new int[]{1,2,3,5};

        hSet.add(2);
        hSet.add(2);
        hSet.add(1);
        hSet.add(3);
        hSet.add(5);
        hSet.add(4);
        hSet.remove(2);
        hSet.add(null); // null 허용
        System.out.println(hSet.contains(3));// true 출력;
        System.out.println(hSet.size()); //4 출력


        Iterator<Integer> iter = hSet.iterator();

        while(iter.hasNext()){
           System.out.println(iter.next()); // 1 3 4 5 출
        }
        hSet.clear();
        System.out.println(hSet.size()); // 0출력
        System.out.println(hSet.isEmpty()); // true;

    }
```

> - 삽입한 순서를 보장 X
> - 기본적으로 오름차순으로 데이터 정렬
