'''
Created on Nov 11, 2023

@author: tscal
'''

import hashlib

def main():
    """
    Simple password encoding program, takes input and encodes it to
    MD-5, SHA-256, and SHA-512, either salted or unsalted.
    """
    SALT = "trythisagainbutnowitissalted"
    print("Please enter a password to encode")
    original_message = input()
    #encode message to bytes
    message = original_message.encode()
    #MD-5 unsalted
    print(f"MD-5 unsalted {hashlib.md5(message).hexdigest()}")
    #SHA-256 unsalted
    print(f"SHA-256 unsalted {hashlib.sha256(message).hexdigest()}")
    #SHA-512 unsalted
    print(f"SHA-512 unsalted {hashlib.sha512(message).hexdigest()}")
    #MD-5 salted
    salt_message = SALT + original_message
    salt_message = salt_message.encode()
    print(f"MD-5 salted {hashlib.md5(salt_message).hexdigest()}")
    #SHA 2 family salted
    print(f"SHA-256 salted {hashlib.sha256(salt_message).hexdigest()}")
    print(f"SHA-512 salted {hashlib.sha512(salt_message).hexdigest()}")
if __name__ == '__main__':
    main()