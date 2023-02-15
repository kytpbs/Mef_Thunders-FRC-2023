import random
from networktables import NetworkTables

def main():
    while True:
        randint = random.randint(0,100)
        print(randint)
        ntinst = NetworkTables.getDefault()
        ntinst.startServer()
        ntinst.putNumber('test', randint)

if __name__ == "__main__":
    main()