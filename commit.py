import os
import sys
import subprocess
import re
import urllib.request
import json
import tkinter as tk

# 폴더명 매핑
folders = {
    "dp": "DP",
    "bfs": "DFS, BFS",
    "dfs": "DFS, BFS",
    "구현": "구현, 문자열",
    "문자열": "구현, 문자열",
    "그리디": "Greedy, Sorting",
    "정렬": "Greedy, Sorting",
    "이분탐색": "Binary Search, Two Pointer",
    "투포인터": "Binary Search, Two Pointer",
    "브루트포스": "Bruteforce, Backtracking",
    "백트래킹": "Bruteforce, Backtracking",
    "그래프": "Graph, MST, Dijkstra",
    "수학": "수학, 분할 정복",
    "자료구조": "자료구조"
}

def get_clipboard():
    """pip 설치 없이 내장 tkinter를 사용해 클립보드 텍스트를 가져옵니다."""
    root = tk.Tk()
    root.withdraw()
    try:
        result = root.clipboard_get()
    except tk.TclError:
        result = ""
    root.destroy()
    return result

def get_problem_info(problem_id):
    """내장 urllib를 사용해 solved.ac API를 호출합니다."""
    url = f"https://solved.ac/api/v3/problem/show?problemId={problem_id}"
    req = urllib.request.Request(url, headers={"User-Agent": "Mozilla/5.0"})
    try:
        with urllib.request.urlopen(req) as response:
            data = json.loads(response.read().decode("utf-8"))
            level = data.get("level", 0)
            title = data.get("titleKo", "Unknown")
            
            if level == 0:
                tier_str = "Unrated"
            else:
                tiers = ["Bronze", "Silver", "Gold", "Platinum", "Diamond", "Ruby"]
                tier_idx = (level - 1) // 5
                sub_tier = 5 - ((level - 1) % 5)
                tier_str = f"{tiers[tier_idx]}{sub_tier}"
            return tier_str, title
    except Exception as e:
        print(f"API 호출 에러: {e}")
        return None, None

def sanitize_filename(name):
    name = re.sub(r'[\\/:*?"<>|]', '', name)
    return name.replace(" ", "_")

def main():
    if len(sys.argv) < 3:
        print("사용법: python commit.py [문제번호] [알고리즘키워드]")
        sys.exit(1)

    problem_num = sys.argv[1]
    keyword = sys.argv[2].lower()

    target_folder = folders.get(keyword)
    if not target_folder:
        print("키워드에 해당하는 폴더가 없습니다.")
        sys.exit(1)

    tier, title = get_problem_info(problem_num)
    if not tier:
        print("문제 정보를 찾을 수 없습니다.")
        sys.exit(1)

    safe_title = sanitize_filename(title)
    file_name_body = f"{tier}_{problem_num}_{safe_title}"
    ext = ".java"
    
    code = get_clipboard()
    if not code.strip():
        print("클립보드가 비어 있습니다.")
        sys.exit(1)

    # [코드 정리 로직]
    # 1. 백준 특유의 유령 공백(\xa0)을 일반 공백으로 치환
    code = code.replace('\xa0', ' ')
    
    # 2. 불필요하게 많은 빈 줄을 한 줄로 축소
    code = re.sub(r'\n\s*\n', '\n\n', code)
    
    # 3. 자바 파일명 규칙을 위해 'public class Main'을 'public class 파일명'으로 자동 변경
    code = re.sub(r'public\s+class\s+Main', f'public class {file_name_body}', code)

    file_path = os.path.join(target_folder, f"{file_name_body}{ext}")

    if not os.path.exists(target_folder):
        os.makedirs(target_folder)

    with open(file_path, "w", encoding="utf-8") as f:
        f.write(code)

    print(f"파일 생성 완료: {file_path}")

    subprocess.run(["git", "add", file_path])
    subprocess.run(["git", "commit", "-m", f"Add: {tier} {problem_num} {title}"])
    subprocess.run(["git", "push"])
    
    print("깃허브 푸시가 완료되었습니다.")

if __name__ == "__main__":
    main()