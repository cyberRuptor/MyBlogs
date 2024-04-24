import requests
import certifi
url = 'https://optimus.airtel.com/v1/services/9100000DUMMY?lineOfBusiness=mobility'
headers = {'subscribercode': '8982812071D1CAC5861B6B4D5A95598D30896BDB55DC1C5CF1B3355CBDB96F2F'}
try:
    r = requests.get(url, headers=headers)
    print('ran successful')
    print(r.status_code)
    # prints the int of the status code. Find more at httpstatusrappers.com :)
except requests.ConnectionError:
    print("failed to connect")
