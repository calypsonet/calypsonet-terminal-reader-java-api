# Changelog
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

## [1.3.0] - 2023-05-22
### Added
- Introduced a new capability to export a locally processed card selection scenario to be imported and analyzed remotely
  by another card selection manager.
  For this purpose, the following two methods have been added to the `CardSelectionManager` interface:
  - `exportProcessedCardSelectionScenario`
  - `importProcessedCardSelectionScenario`

## [1.2.0] - 2023-01-10
### Added
- `ConfigurableCardReader.getCurrentProtocol` method to retrieve the physical protocol name currently used by the reader.
### Changed
- UML diagrams moved to a dedicated repository (see `README.md` file).

## [1.1.0] - 2022-10-26
### Added
- The possibility to import/export a card selection scenario (issue [#9]) via the new methods
  `exportCardSelectionScenario` and `importCardSelectionScenario` of the `CardSelectionManager` API.
- `CHANGELOG.md` file (issue [#7]).
- CI: Forbid the publication of a version already released (issue [#5]).

## [1.0.0] - 2021-10-06
This is the initial release.

[unreleased]: https://github.com/calypsonet/calypsonet-terminal-reader-java-api/compare/1.3.0...HEAD
[1.3.0]: https://github.com/calypsonet/calypsonet-terminal-reader-java-api/compare/1.2.0...1.3.0
[1.2.0]: https://github.com/calypsonet/calypsonet-terminal-reader-java-api/compare/1.1.0...1.2.0
[1.1.0]: https://github.com/calypsonet/calypsonet-terminal-reader-java-api/compare/1.0.0...1.1.0
[1.0.0]: https://github.com/calypsonet/calypsonet-terminal-reader-java-api/releases/tag/1.0.0

[#9]: https://github.com/calypsonet/calypsonet-terminal-reader-java-api/issues/9
[#7]: https://github.com/calypsonet/calypsonet-terminal-reader-java-api/issues/7
[#5]: https://github.com/calypsonet/calypsonet-terminal-reader-java-api/issues/5