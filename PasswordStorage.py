import tkinter as tk

window = tk.Tk()
frame = tk.Frame(window)
userLabel = tk.Label(frame, text="Username")
userLabel.pack()
userInput = tk.Entry()
userInput.pack()
pswdLabel = tk.Label(frame, text="Password")
pswdLabel.pack()
pswdInput = tk.Entry()
pswdInput.pack()
submit = tk.Button(frame, text="Log In", command=logInToApp(userInput.get(), pswdInput.get()))
window.mainloop()

def logInToApp(usrnm, pswd):
    cursor = db.cursor()
    cursor.execute("SELECT * FROM logdb WHERE username='"+usrnm+"' AND password='"+pswd+"';")
    result = cursor.fetchall()

    if(result > 1):
        '''go to next window'''
        