FROM sbt-compiler:0.13.17

COPY . /app

WORKDIR /app

ENTRYPOINT ["sbt"]
CMD ["run"]
