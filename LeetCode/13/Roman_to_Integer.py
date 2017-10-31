def romanToInt(s):
    dict = {"I":1,"V":5,"X":10,"L":50,"C":100,"D":500,"M":1000}
    re=pre=dict[s[0]]
    i = 1
    while i<len(s):
        if dict[s[i]]<=pre:
            re = re + dict[s[i]]
        else:
            re = re - 2*pre + dict[s[i]]
        pre = dict[s[i]]
        i = i + 1
    return re
