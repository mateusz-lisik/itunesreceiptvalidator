# iTunes Receipt Validator
Validating iTunes receipt from your java projects made easy - or easier - at least!

## Project State
At this moment library only support one time payments. Feel free to contribute more or just state that you need that
functionality.  Also test suite it somewhat basic right now.

## Sample usage

```
final ReceiptValidator receiptValidator = new ReceiptValidator(Environment.SANDBOX);
final VerificationResponse verificationResponse = receiptValidator.verifyReceipt(<<Your base64 receipt data>>);
final Receipt receipt = verificationResponse.getReceipt();
```


## Releases
Current release is `0.5`.

### Gradle configuration
```
compile 'it.lisik.itunesvalidator:itunesvalidator:0.5'
```

### Maven configuration

```
<dependency>
  <groupId>it.lisik.itunesvalidator</groupId>
  <artifactId>itunesvalidator</artifactId>
  <version>0.5</version>
  <type>pom</type>
</dependency>
```