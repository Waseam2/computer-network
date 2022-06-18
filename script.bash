sudo apt update
sudo apt upgrade 

cd /content/drive/MyDrive/api

apt install python3.6-venv
python3.6 -m venv $1

source ./$1/bin/activate


python -m pip install --upgrade pip

pip install fastapi
pip install uvicorn
pip install fastapi[all]
pip install gunicorn
pip freeze > requirements.txt
pip install -r requirements.txt

cp /content/drive/MyDrive/v8/model2.h5 /content/drive/MyDrive/api/$1
cp /content/drive/MyDrive/api/api2/main.py  /content/drive/MyDrive/api/$1

pip install opencv-python
pip install tensorflow
pip install pylint