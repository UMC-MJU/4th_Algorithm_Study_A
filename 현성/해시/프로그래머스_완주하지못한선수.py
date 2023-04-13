def solution(participant, completion):
    participant_dict = {}

    for person in participant:
        if person in participant_dict:
            participant_dict[person] += 1
        else:
            participant_dict[person] = 1

    for person in completion:
        participant_dict[person] -= 1

    for person in participant_dict:
        if participant_dict[person] > 0:
            return person