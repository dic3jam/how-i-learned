from statistics import median

def activityNotifications(expenditure, d):
    notice = 0
    lower = 0
    higher = d
    while higher <= len(expenditure):
        trail = expenditure[lower:higher-1]
        today = array[higher]
        med = 2 * (median(trail))
        if today >= med:
            notice += 1
        lower += 1
        higher += 1
    return notice
