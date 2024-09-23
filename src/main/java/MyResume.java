import java.io.File;
import java.io.IOException;

public class MyResume {
    public static void main(String[] args) throws IOException {
        new Resume(new Section[] {
            new Header(
                "Nico Salm",
                new ContactInfo[] {
                    Link.email("nico@salmPLZnoSPAM.PLZnoSPAMdev".replace("PLZnoSPAM", "")),
                    Link.https(Icon.LINKEDIN, "www.linkedin.com/in/nicosalm"),
                    Link.https(Icon.GITHUB, "github.com/nicosalm")
                }
            ),
            new LabeledSection(
                "EDUCATION",
                new Item[] {
                    new Item(
                        new ItemElement[] {
                            new BasicText("University of Wisconsin-Madison", Alignment.LEFT, Format.BOLD),
                            new BasicText("GPA: 3.5/4.0", Alignment.RIGHT, Format.NORMAL),
                            new BasicText("Bachelor of Science in Computer Science and Data Science (dm.)", Alignment.LEFT, Format.NORMAL),
                            new BasicText("May 2026", Alignment.RIGHT, Format.NORMAL),
                            new BulletPoint("Selected coursework: Algorithms, Data Structures, Big Data Systems, Databases, Machine Organization & Programming, Statistical Modeling and Analysis, Machine Learning, Data Ethics and Policy, Linear Algebra, Calculus"),
                        }
                    )
                }
            ),
            new LabeledSection("EXPERIENCE", new Item[] {
                experience(
                    "Data Science Intern",
                    "Rogers Machinery Company, Inc.",
                    "May 2024 - August 2024",
                    "Achieved $6.4k+/year in savings and reduced workload by 8hrs/month by creating an ETL pipeline.",
                    "Improved operational efficiency and resource allocation by developing predictive models for churn, performance, inventory, and utilization metrics.",
                    "Increased onboarding speed 20x by developing ETL and data analysis documentation."
                ),
                experience(
                    "ML Research Assistant",
                    "Dane Morgan Materials Science Research Group",
                    "September 2022 - May 2024",
                    "Achieved precise generation of novel matrix structures by enhancing the accuracy of compression and reconstruction using a variational auto-encoder.",
                    "Realized a 20% increase in validation accuracy by expanding and cleaning the materials dataset.",
                    "Enhanced throughput during training by utilizing GPUs from the HTCondor computing cluster.",
                    "Applied convolutional neural networks to materials datasets and deployed them to the cloud."
                ),
                experience(
                    "Projects Lab Coordinator",
                    "Undergraduate Projects Lab (UPL), UW-Madison",
                    "January 2024 - Present",
                    "Captured real-time monitoring of lab occupancy by implementing a Raspberry Pi and camera setup using the YOLOv7 computer vision model, which updates the count on a Discord channel.",
                    "Developed the lab website using Astro and Tailwind; managed GitHub open-source contributions, issues, and PRs."
                ),
            }),
            new LabeledSection("PROJECTS", new Item[] {
                projectWithTools(
                    "Algorithm Visualizer",
                    "Go, JavaScript, Docker, Git",
                        "Developed a cure for cancer using PHP and Laravel",
                        "Not been released yet because I can't think of a good LinkedIn post title"
                ),
                projectWithTools(
                    "MIT Quantum Photonic GAN",
                    "Python (Quandela Perceval, PyTorch), Circuit Design, Quantum Computing",
                        "Achieved 45% fidelity by implementing a Quantum Generative Adversarial Network (Q-GAN) from scratch using secant descent and vectorized approaches over a single 24-hour session.",
                        "Presented the Q-GAN to a panel of scientists, highlighting its innovative and technical aspects.",
                        "Led a 5-person team to a Top 3 finish at MIT’s IQuHACK 2024, excelling in Quandela’s Quantum Photonics Challenge."
                ),
                projectWithTools(
                    "Handwritten Code Interpreter",
                    "React, Bootstrap, Express, Java, Git",
                        "Compiled and ran handwritten code from .PNG images using Google OCR and Java Reflections.",
                        "Streamlined image collection and elevated UX by wrapping the interpreter in a front-end built with React and Axios."
                )
            }),
            new LabeledSection("ACHIEVEMENTS AND LEADERSHIP", new Item[] {
                new Item(new ItemElement[] {
                    new BasicText("MIT IQuHACK Top 3 | Quantum Machine Learning, Circuit Design", Alignment.LEFT, Format.NORMAL),
                    new BasicText("IBM Quantum Excellence Scholar | Quantum Computing", Alignment.LEFT, Format.NORMAL),
                    new BasicText("Quantum Computing Club Vice Present | Teaching, Talks & Workshops", Alignment.LEFT, Format.NORMAL),
                    new BasicText("Hackathon Lead Organizer | 380+ attendees, 100+ project submissions, 18K+ in funding", Alignment.LEFT, Format.NORMAL),
                })
            }),

            new LabeledSection("TECHNICAL SKILLS", new Item[] {
                new Item(new ItemElement[] {
                    new BasicText("Languages: Python, Go, C, Java, SQL (PostgreSQL, MySQL), R, JavaScript, HTML/CSS", Alignment.LEFT, Format.NORMAL),
                    new BasicText("Libraries and Frameworks: React, Astro, pandas, NumPy, Matplotlib, Scikit-learn, PyTorch, Flask, JUnit", Alignment.LEFT, Format.NORMAL),
                    new BasicText("Developer Tools: Shell, Git, Docker, Amazon AWS, Power BI, Vim, Linux, macOS, Windows", Alignment.LEFT, Format.NORMAL),
                })
            })
        }).write(new File("my-resume.pdf"));
    }
    
    static Item project(String name, String... bullets) {
        var ieArr = new ItemElement[bullets.length + 2];
        ieArr[0] = new BasicText(name, Alignment.LEFT, Format.BOLD);
        ieArr[1] = new Padding(1f);
        for (int i = 0; i < bullets.length; i++) {
            ieArr[i + 2] = new BulletPoint(bullets[i]);
        }
        return new Item(ieArr);
    }

    static Item projectWithTools(String name, String tools, String... bullets) {
        var ieArr = new ItemElement[bullets.length + 2];
        ieArr[0] = new JakeStyleProjectText(name, tools);
        ieArr[1] = new Padding(1f);
        for (int i = 0; i < bullets.length; i++) {
            ieArr[i + 2] = new BulletPoint(bullets[i]);
        }
        return new Item(ieArr);
    }

    static Item experience(String name, String title, String date, String... bullets) {
        var ieArr = new ItemElement[bullets.length + 4];
        ieArr[0] = new BasicText(name, Alignment.LEFT, Format.BOLD);
        ieArr[1] = new BasicText(date, Alignment.RIGHT, Format.NORMAL);
        ieArr[2] = new BasicText(title, Alignment.LEFT, Format.NORMAL);
        ieArr[3] = new Padding(1f);
        for (int i = 0; i < bullets.length; i++) {
            ieArr[i + 4] = new BulletPoint(bullets[i]);
        }
        return new Item(ieArr);
    }
}
