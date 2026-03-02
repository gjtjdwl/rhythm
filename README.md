# rhythm

알고리즘 문제 풀이 소스 코드를 보관하고 관리하는 저장소입니다.
🕺오예 두둠칫

# commit.py 사용법

1. 맞은 코드 클립보드에 복사(Ctrl + C)
2. 복사한 상태에서 스크립트가 있는 경로에서 아래 명령어 실행

```bash
python commit.py [문제번호] [알고리즘키워드]
```
```bash
# 실행 예시
python commit.py 1000 구현
```
## 📁 폴더 매핑 키워드

| 입력 키워드 | 저장되는 폴더명 |
| :--- | :--- |
| `dp` | 📁 DP |
| `bfs`, `dfs` | 📁 DFS & BFS |
| `구현`, `문자열` | 📁 구현 & 문자열 |
| `그리디`, `정렬` | 📁 Greedy & Sorting |
| `이분탐색`, `투포인터` | 📁 Binary Search & Two Pointer |
| `브루트포스`, `백트래킹` | 📁 Bruteforce & Backtracking |
| `그래프` | 📁 Graph & MST & Dijkstra |
| `수학` | 📁 수학 & 분할 정복 |
| `자료구조` | 📁 자료구조 |

> 💡 **참고:** 폴더명이나 키워드를 추가/수정하고 싶다면 `commit.py` 코드 상단의 `folders` 딕셔너리를 변경