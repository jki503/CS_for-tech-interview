---
title: DataStructure,
category: algorithm,
tags: 자료구조, 자바, API정리
Author: Jung
---

## My Goal

---

- 자료구조 공부 겸 JAVA API 정리

</br>
</br>
</br>

## Table of Contents

---

- [Stack](#stack)
- [Queue](#queue)
- [Set](#set)

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

> - push,empty는 stack 함수.
> - add, isEmpty는 vector 함수.
> - stack이 vector를 상속받는 구조.

### **Queue**

### **Set**
