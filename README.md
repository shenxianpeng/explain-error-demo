# explain-error-demo

Sample projects with deliberately broken builds, used to demonstrate the
[Explain Error Plugin](https://plugins.jenkins.io/explain-error/) for Jenkins.

| Path | Stack | How it fails |
|------|-------|--------------|
| `/` (inventory-service) | Python, pip | `requirements.txt` pins a release that does not exist |
| `examples/payments-api` | Java, Maven | a unit test hits a `NullPointerException` |
| `examples/storefront-web` | Node, npm | `package.json` and `package-lock.json` are out of sync |
| `examples/orders-image` | Docker | the build agent has no Docker daemon |

Nothing here is meant to be fixed by hand: the failures are the point.
Pull requests opened by the plugin's auto-fix feature show up in this repository.
