import mysql.connector
import webbrowser
import matplotlib.pyplot as plt
import mpld3
import nltk

nltk.download("vader_lexicon")
from nltk.sentiment.vader import SentimentIntensityAnalyzer

conn = mysql.connector.connect(
    user="sql6413088",
    password="mp1MpibM4p",
    host="sql6.freemysqlhosting.net",
    port=3306,
    database="sql6413088",
)

if conn:
    print("Connected Successfully")
else:
    print("Connection Not Established")

n = 4
statement = "SELECT remarks,assignment_id,marks_obtained FROM student_marks WHERE student_id = " + \
    str(n)
cursor = conn.cursor()
cursor.execute(statement)
result = cursor.fetchall()
assignment = []
marks = []
remarks = []
print(result)
for i in result:
    i = list(i)
    assignment.append(i[1])
    marks.append(int(i[2]))
    remarks.append(i[0])
print(assignment)
print(marks)
print(remarks)

scores = []
sentiment = {}
positive = 0
negative = 0
vader = SentimentIntensityAnalyzer()
for i in remarks:
    print(i)
    scores.append(vader.polarity_scores(i)["compound"])
print(scores)
for i in scores:
    if i >= 0:
        positive += 1
    else:
        negative += 1
sentiment["Positive"] = positive
sentiment["Negative"] = negative
print(sentiment)

conn.close()
cursor.close()

fig1 = plt.figure()
ax1 = fig1.add_axes([0, 0, 1, 1])
ax1.pie(sentiment.values(), labels=sentiment.keys(), autopct="%1.2f%%")
ax1.axis("equal")
#plt.savefig("E:\Eclipse\Test\pics\pie.png")
fig1.savefig("./pics/pie.png")
fig = plt.figure()
ax = fig.add_axes([0.5, 0.5, 0.5, 0.5])
ax.bar(assignment, marks, width=0.20)
#plt.savefig("./bar.png")
fig.savefig("./pics/bar.png")