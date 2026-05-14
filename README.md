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

<img width="1913" height="897" alt="Screenshot 2026-05-14 143421" src="https://github.com/user-attachments/assets/bd185b16-f526-4e1d-b0a0-1501be1162aa" />

**Step 2: Verification in AWS S3 Bucket**

<img width="1539" height="563" alt="Screenshot 2026-05-14 143543" src="https://github.com/user-attachments/assets/a377de85-0c62-4b98-9733-59e5151dd595" />

**Step 3: Output to S3**

<img width="1082" height="740" alt="Screenshot 2026-05-14 143439" src="https://github.com/user-attachments/assets/7b718bbb-dc55-4181-a733-8e082a26da85" />

### 2. AWS-Integrated Research Newsletter (Project 2)
A functional subscription service designed to handle student data persistence
*   **Workflow:** Frontend Form → **Spring Boot (on Elastic Beanstalk)** → **AWS SDK v2** → **DynamoDB**.
*   **Benefit:** Replaces local storage with a scalable NoSQL database, allowing the app to handle thousands of concurrent users without data loss.

**Step 1: Signing up for the Newsletter**

<img width="1915" height="867" alt="Screenshot 2026-05-14 144225" src="https://github.com/user-attachments/assets/82cb4ad1-6547-4eb7-a64d-0b9323f13fec" />

**Step 2: Confirming that it is adding to the DynamoDB**

<img width="1134" height="483" alt="Screenshot 2026-05-14 142019" src="https://github.com/user-attachments/assets/a76ea5e8-7a24-4d60-bd8e-bff95daf3b83" />

### 3. Automated Computer Vision Pipeline (Project 3)
An intelligent image-analysis tool for campus media management.
*   **Workflow:** Image Upload → **Amazon S3** → **Amazon Rekognition**.
*   **Result:** Automated object detection and metadata labeling for uploaded assets.

**Test Case: Identity Verification**

<img width="1912" height="894" alt="Screenshot 2026-05-14 144638" src="https://github.com/user-attachments/assets/e1b39786-e95a-4a6f-bc7d-b132656525a1" />

<img width="1900" height="866" alt="Screenshot 2026-05-14 144654" src="https://github.com/user-attachments/assets/68d739c1-f98f-4967-a68c-d6bdb3198774" />


### 4. Enterprise Observability Suite (Project 4)
A production-grade monitoring system is implemented across the Hub infrastructure.
*   **Workflow:** Backend Exception → **Try-Catch Logic** → **Amazon SNS**.
*   **Result:** Instant email alerts for system failures, ensuring 99.9% reliability.

**Test Case: This error was created by simulating a backend failure, and immediately receiving an error message**

<img width="1401" height="405" alt="Screenshot 2026-05-14 113440" src="https://github.com/user-attachments/assets/e86ec5e6-12a4-44b0-8c56-e2b2731c757e" />


---

## Portfolio Landing Page

### Campus Hub UI
The main entry point of the application, where the UI mimics the school's colors for a more immersive experience and provides navigation to the integrated cloud modules.

<img width="1909" height="835" alt="Screenshot 2026-05-14 141839" src="https://github.com/user-attachments/assets/0926b311-9d38-4a3b-aba6-5193e69925f7" />


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
