FROM hseeberger/scala-sbt:8u265_1.4.3_2.13.4

ADD . /ConnectFour

WORKDIR /ConnectFour

RUN sbt compile

CMD sbt run