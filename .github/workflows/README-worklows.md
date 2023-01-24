# Notes to self:

- Unlike gitlab, re-usability is severely limited with github actions. Example:
    - `Invalid workflow file: .github/workflows/all-tests.yml#L5
      invalid value workflow reference: workflows must be defined at the top level of the .github/workflows/ directory
      `

- Choosing self-hosted runners
    - on the `runs-on` section add self-hosted label and any other label need to run on correct host
    - https://docs.github.com/en/actions/hosting-your-own-runners/using-self-hosted-runners-in-a-workflow
    - https://docs.github.com/en/actions/using-jobs/choosing-the-runner-for-a-job