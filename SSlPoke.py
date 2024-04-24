import requests
import certifi
url = ''
headers = {''}
try:
    r = requests.get(url, headers=headers)
    print('ran successful')
    print(r.status_code)
    # prints the int of the status code. Find more at httpstatusrappers.com :)
except requests.ConnectionError:
    print("failed to connect")
