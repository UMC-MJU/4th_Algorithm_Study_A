def solution(participant, completion):
    # 참여자명단에 있지만 완주자 명단에 없으면 완주하지 못한 선수

    # for i in participant:
    #     if i in completion:
    #         completion.remove(i)
    #     else:
    #         answer = i

    participant.sort()
    completion.sort()

    for i in range(len(completion)):
        if participant[i] != completion[i]:
            return participant[i]

    return participant[-1]
