# CSUMB Campus Hub & Cloud Architecture Portfolio

A full-stack ecosystem demonstrating enterprise-level cloud integration. This repository serves as the central hub for four distinct AWS-powered projects.

## The Tech Stack & AWS Ecosystem
This portfolio leverages a wide array of AWS managed services to ensure scalability, security, and high availability:

*   **Compute & Logic:** Java 17 (Spring Boot), Python (Boto3), AWS Lambda.
*   **Database & Storage:** Amazon DynamoDB (NoSQL), Amazon S3 (Object Storage).
*   **Networking & Delivery:** Amazon API Gateway, Amazon CloudFront (CDN), Route 53.
*   **Monitoring & AI:** Amazon SNS (Alerting), Amazon Rekognition (Computer Vision).

---

## Integrated Projects

### 1. Serverless Resume API (Project 1)
Instead of a static document, I engineered a serverless API that fetches professional data dynamically.
*   **Workflow:** User Request → **API Gateway** → **AWS Lambda** → **DynamoDB**.
*   **Result:** A JSON-formatted response of my professional bio.

**Step 1: Uploading local resume.json**

<img width="1913" height="897" alt="Screenshot 2026-05-14 143421" src="https://github.com/user-attachments/assets/0d95b35c-321c-45e9-a620-48b3a27f7474" />

**Step 2: Verification in AWS S3 Bucket**

<img width="1539" height="563" alt="Screenshot 2026-05-14 143543" src="https://github.com/user-attachments/assets/ad07d35d-2c42-49e8-b776-2fb171f749cf" />

**Step 3: Output to S3**

<img width="1082" height="740" alt="Screenshot 2026-05-14 143439" src="https://github.com/user-attachments/assets/d4bd4451-8895-46b8-bf4d-ec71f1f321ff" />

### 2. AWS-Integrated Research Newsletter (Project 2)
A functional subscription service designed to handle student data persistence
*   **Workflow:** Frontend Form → **Spring Boot (on Elastic Beanstalk)** → **AWS SDK v2** → **DynamoDB**.
*   **Benefit:** Replaces local storage with a scalable NoSQL database, allowing the app to handle thousands of concurrent users without data loss.

**Step 1: Signing up for the Newsletter**

<img width="1915" height="867" alt="Screenshot 2026-05-14 144225" src="https://github.com/user-attachments/assets/47ac1d3a-2726-4334-a4df-9cb757624ed3" />

**Step 2: Confirming that it is adding to the DynamoDB**

<img width="1000" alt="DynamoDB Screenshot" src="https://github.com/user-attachments/assets/d3501713-2d2a-485c-a611-7b2e23086680" />


### 3. Automated Computer Vision Pipeline (Project 3)
An intelligent image-analysis tool for campus media management.
*   **Workflow:** Image Upload → **Amazon S3** → **Amazon Rekognition**.
*   **Result:** Automated object detection and metadata labeling for uploaded assets.

**Test Case: Identity Verification**

<img width="1912" height="894" alt="Screenshot 2026-05-14 144638" src="https://github.com/user-attachments/assets/dadb6465-8b05-4404-ad64-abf705aa6e61" />

<img width="1900" height="866" alt="Screenshot 2026-05-14 144654" src="https://github.com/user-attachments/assets/09e6aa97-744b-460d-8b12-7bddbe6841fb" />


### 4. Enterprise Observability Suite (Project 4)
A production-grade monitoring system is implemented across the Hub infrastructure.
*   **Workflow:** Backend Exception → **Try-Catch Logic** → **Amazon SNS**.
*   **Result:** Instant email alerts for system failures, ensuring 99.9% reliability.

**Test Case: This error was created by simulating a backend failure, and immediately receiving an error message**

<img width="1000" alt="SNS Email Screenshot" src="https://github.com/user-attachments/assets/9cd78ff1-04b6-4e64-b1a4-1d7da5f51301" />

---

## Portfolio Landing Page

### Campus Hub UI
The main entry point of the application, where the UI mimics the school's colors for a more immersive experience and provides navigation to the integrated cloud modules.

<img width="1000" alt="Hub UI Screenshot" src="https://github.com/user-attachments/assets/6cf46746-bd92-4a59-bb09-ce23c8ead5ef" />

---

## Deployment & Distribution
To mirror professional standards, the public-facing components of this portfolio are distributed via **Amazon CloudFront**. This ensures low-latency access by caching content at AWS Edge Locations, while **Route 53** manages the DNS for a custom, professional domain.

---

### Installation & Setup
To run this project locally, you must have:
1.  **Java 17+** and **Maven** installed.
2.  **AWS Credentials** configured via the AWS CLI (`~/.aws/credentials`).
3.  A DynamoDB table named `NewsletterUsers` in the `us-east-1` region.
4.  An SNS Topic with a confirmed email subscription.
