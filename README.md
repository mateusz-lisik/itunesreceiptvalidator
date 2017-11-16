# iTunes Receipt Validator
[![FOSSA Status](https://app.fossa.io/api/projects/git%2Bgithub.com%2Fmatteprl%2Fitunesreceiptvalidator.svg?type=shield)](https://app.fossa.io/projects/git%2Bgithub.com%2Fmatteprl%2Fitunesreceiptvalidator?ref=badge_shield)

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

## License
[![FOSSA Status](https://app.fossa.io/api/projects/git%2Bgithub.com%2Fmatteprl%2Fitunesreceiptvalidator.svg?type=large)](https://app.fossa.io/projects/git%2Bgithub.com%2Fmatteprl%2Fitunesreceiptvalidator?ref=badge_large)