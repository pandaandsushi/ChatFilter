# ChatFilter Simulation
## Made By Thea Josephine 13522012
Chat Filter Simulation on Shopee E-Commerce Using Regex and Pattern Matching Algorithm

Will check the following:
- vulgar words
- asking customer to cancel an order
- sharing private information that could lead to dangerous out of app transaction (email, social media, phone number, links)

```
src/
├── data/
│   ├── badwords.txt
│   ├── cancel.txt
├── Main.java
├── BadWords.java
├── Cancel.java
├── Translate.java
├── PrivateInfo.java
├── BFAlgorithm.java
├── KMPAlgorithm.java
└── BMAlgorithm.java

```
### To Run
- Open VSCode, open terminal on src directory
- Compile using `javac Main.java` then `java Main`

### To Use
- Input the text you want to check
- Input the type of algorithm (KMP/BM/BF)
- Results between checks are displayed separately on terminal